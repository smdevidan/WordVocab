package com.test.wordvocab.service;

import com.test.wordvocab.db.IWordsDao;

/**
 * Database access service. Created by dsunder on 12/20/2015.
 */
public interface IDaoService
{

    /**
     * Get word dao service
     * @return
     */
    IWordsDao getWordDaoService();
}
