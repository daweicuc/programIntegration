package cuc.dawei.springbootprogramintegration.mapper;

import cuc.dawei.springbootprogramintegration.entity.Navbar;
import cuc.dawei.springbootprogramintegration.entity.NavbarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavbarMapper {
    long countByExample(NavbarExample example);

    int deleteByExample(NavbarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Navbar record);

    int insertSelective(Navbar record);

    List<Navbar> selectByExample(NavbarExample example);

    Navbar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Navbar record, @Param("example") NavbarExample example);

    int updateByExample(@Param("record") Navbar record, @Param("example") NavbarExample example);

    int updateByPrimaryKeySelective(Navbar record);

    int updateByPrimaryKey(Navbar record);
}