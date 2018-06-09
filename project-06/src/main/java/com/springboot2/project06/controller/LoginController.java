package com.springboot2.project06.controller;
import com.springboot2.project06.entity.UserEntity;
import com.springboot2.project06.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity userEntity){
        return userJPA.save(userEntity);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
    @RequestMapping(value = "/login")
    public String login(UserEntity userEntity, HttpServletRequest request){
        if(userEntity != null && userEntity.getName() != null && userEntity.getPwd() != null){
            if(userJPA.findOneByName(userEntity.getName(),userEntity.getPwd()) > 0){
                request.getSession().setAttribute("_userEntity",userEntity);
                return "登录成功";
            }else {
                return "登录失败！";
            }
        }else {
            return "登录错误！";
        }
    }
}
