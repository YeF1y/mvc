package com.vo;

import java.util.Date;

public class Message {
    private int messageID; //会自增
    private String title;
    private String content;
    private String writer;
    private String writeDate; //日期格式:年月日 时分秒

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", writeDate=" + writeDate +
                '}';
    }
}
