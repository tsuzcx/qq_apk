package com.tencent.token.core.bean;

import java.io.Serializable;

public class JLZone$JLZoneServer
  implements Serializable
{
  private static final long serialVersionUID = 6282670364777245762L;
  public int serverID;
  public String serverName;
  
  public JLZone$JLZoneServer(JLZone paramJLZone, String paramString, int paramInt)
  {
    this.serverName = paramString;
    this.serverID = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.JLZone.JLZoneServer
 * JD-Core Version:    0.7.0.1
 */