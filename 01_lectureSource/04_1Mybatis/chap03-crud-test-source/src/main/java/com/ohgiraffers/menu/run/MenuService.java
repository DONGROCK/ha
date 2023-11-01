package com.ohgiraffers.menu.run;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.menu.common.Template.getSqlSession;

public class MenuService {

//    private MenuMapper mapper;
    public List<MenuDTO> showAllMenu() {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//        mapper = sqlSession.getMapper(MenuMapper.class);

    List<MenuDTO> menuList = menuMapper.showAllMenu();

    sqlSession.close();

    return menuList;
    }
}
