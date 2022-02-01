package com.tencent.token;

import com.tencent.service.update.e;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class ex
{
  NetworkInterface a;
  
  public ex(NetworkInterface paramNetworkInterface)
  {
    this.a = paramNetworkInterface;
  }
  
  public static Enumeration<ex> a()
  {
    if (!e.a().b()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = NetworkInterface.getNetworkInterfaces();
    if (localObject != null)
    {
      localObject = Collections.list((Enumeration)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new ex((NetworkInterface)((Iterator)localObject).next()));
      }
    }
    return Collections.enumeration(localArrayList);
  }
  
  public boolean b()
  {
    return this.a.isUp();
  }
  
  public List<InterfaceAddress> c()
  {
    return this.a.getInterfaceAddresses();
  }
  
  public String d()
  {
    return this.a.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ex
 * JD-Core Version:    0.7.0.1
 */