package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OptionResponse
  extends ActiveSyncResponse
{
  private ArrayList<String> allowMethods = new ArrayList();
  private ArrayList<String> commands = new ArrayList();
  private ArrayList<String> versions = new ArrayList();
  
  public OptionResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public ArrayList<String> getAllowMethods()
  {
    return this.allowMethods;
  }
  
  public ArrayList<String> getCommands()
  {
    return this.commands;
  }
  
  public ArrayList<String> getVersions()
  {
    return this.versions;
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {
      return false;
    }
    if (!this.httpResponse.isOk()) {
      return false;
    }
    Iterator localIterator = this.httpResponse.getHeader().entrySet().iterator();
    break label347;
    break label232;
    label39:
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    label232:
    do
    {
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label431;
          }
          localObject2 = (Map.Entry)localIterator.next();
          localObject1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          if (!"Allow".equals(localObject1)) {
            break;
          }
        } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
        localObject1 = ((List)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label39;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
            break;
          }
          localObject2 = ((String)localObject2).trim().split(",");
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localObject3 = localObject2[i];
            this.allowMethods.add(localObject3);
            i += 1;
          }
        }
        if (!"MS-ASProtocolVersions".equals(localObject1)) {
          break label313;
        }
      } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
      localObject1 = ((List)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label39;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          break;
        }
        localObject2 = ((String)localObject2).trim().split(",");
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          this.versions.add(localObject3);
          i += 1;
        }
      }
    } while ((!"MS-ASProtocolCommands".equals(localObject1)) || (localObject2 == null) || (((List)localObject2).size() <= 0));
    label313:
    Object localObject1 = ((List)localObject2).iterator();
    for (;;)
    {
      label347:
      if (!((Iterator)localObject1).hasNext()) {
        break label39;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
        break;
      }
      localObject2 = ((String)localObject2).trim().split(",");
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        this.commands.add(localObject3.trim());
        i += 1;
      }
    }
    label431:
    return true;
  }
  
  public void setAllowMethods(ArrayList<String> paramArrayList)
  {
    this.allowMethods = paramArrayList;
  }
  
  public void setCommands(ArrayList<String> paramArrayList)
  {
    this.commands = paramArrayList;
  }
  
  public void setVersions(ArrayList<String> paramArrayList)
  {
    this.versions = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.OptionResponse
 * JD-Core Version:    0.7.0.1
 */