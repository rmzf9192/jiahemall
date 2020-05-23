package com.el.jiahemall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.el.jiahemall.common.utils.PageUtils;
import com.el.jiahemall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:47:05
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

