package com.tencent.moai.mailsdk.protocol.exchange.model;

import com.tencent.moai.mailsdk.model.Mail;
import java.util.ArrayList;

public class ExchangeReceiveInfo
{
  public ArrayList<Mail> addMailList = new ArrayList();
  public ArrayList<Mail> deleteMailList = new ArrayList();
  public ArrayList<String> flagList = new ArrayList();
  public ArrayList<String> readList = new ArrayList();
  public String syncState;
  public ArrayList<String> unFlagList = new ArrayList();
  public ArrayList<String> unReadList = new ArrayList();
  public ArrayList<Mail> updateMailList = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeReceiveInfo
 * JD-Core Version:    0.7.0.1
 */