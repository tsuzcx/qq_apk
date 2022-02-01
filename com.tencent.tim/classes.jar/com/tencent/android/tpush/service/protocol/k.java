package com.tencent.android.tpush.service.protocol;

import java.util.ArrayList;
import org.json.JSONObject;

public class k
  extends e
{
  public long a = 0L;
  public ArrayList<j> b = new ArrayList();
  
  public MessageType a()
  {
    return MessageType.PUSH_MESSAGE;
  }
  
  public void a(String paramString)
  {
    paramString = new JSONObject(paramString);
    j localj = new j();
    localj.a(paramString);
    this.b.add(localj);
    this.a = (localj.h * 1000000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.k
 * JD-Core Version:    0.7.0.1
 */