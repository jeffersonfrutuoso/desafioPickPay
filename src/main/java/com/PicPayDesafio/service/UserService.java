package com.PicPayDesafio.service;
import com.PicPayDesafio.domain.user.User;
import com.PicPayDesafio.domain.user.UserType;
import com.PicPayDesafio.dtos.UserDTO;
import com.PicPayDesafio.excetion.InsufficientBalanceException;
import com.PicPayDesafio.excetion.UnauthorizedTransactionException;
import com.PicPayDesafio.excetion.UserNotFoundException;
import com.PicPayDesafio.excetion.userAlreadyRegisteredException;
import com.PicPayDesafio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validarTransaction(User enviador, BigDecimal valorDaTransferencia){
        if(enviador.getUserType() == UserType.Lojista){
            throw new UnauthorizedTransactionException("Usuario do tipo lojista não pode fazer transferencia.");
        }

        if(enviador.getCarteira().compareTo(valorDaTransferencia) < 0){
            throw new InsufficientBalanceException("Você não tem Saldo suficiente para realizar a transferencia");
        }
    }

    public List<User> getAllUsers(){
      return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado"));
    }

    public User createUser(UserDTO userDTO){

        if (userRepository.existsByDocumento(userDTO.documento())){
            throw new userAlreadyRegisteredException("Ja existe um usuario com esse documento");
        }

        if (userRepository.existsByEmail(userDTO.email())){
            throw new userAlreadyRegisteredException("ja existe um usuario com esse email");
        }
        User newUser = new User(userDTO);
        saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
