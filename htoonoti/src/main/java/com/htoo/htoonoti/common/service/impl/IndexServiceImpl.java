package com.htoo.htoonoti.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.htoo.htoonoti.common.service.IndexService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("indexService")
public class IndexServiceImpl extends EgovAbstractServiceImpl implements IndexService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexServiceImpl.class);

}
