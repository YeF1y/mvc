package com.factory;

import com.dao.IMessageDAO;
import com.dao.dismiss_INoteDAO;
import com.dao.IPersonDAO;
import com.dao.IRevertDAO;
import com.dao.impl.MessageDAOImpl;
import com.dao.impl.dismiss_NoteDAOImpl;
import com.dao.impl.PersonDAOImpl;
import com.dao.impl.RevertDAOImpl;

public class DAOFactory {
    public static IPersonDAO getPersonDAOInstance()
    {
        return new PersonDAOImpl() ;
    }

    public static dismiss_INoteDAO getNoteDAOInstance()
    {
        return new dismiss_NoteDAOImpl() ;
    }

    public static IRevertDAO getRevertDAOInstance()
    {
        return new RevertDAOImpl();
    }

    public static IMessageDAO getMessageDAOInstance(){return new MessageDAOImpl();}
}
