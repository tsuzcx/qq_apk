package com.tencent.mobileqq.apollo;

import abhw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApolloRender$11$1
  extends IApolloRunnableTask
{
  public ApolloRender$11$1(abhw paramabhw, Map paramMap, int paramInt, byte[] paramArrayOfByte) {}
  
  public String aV()
  {
    return "sendHttpRequest_responseCallback";
  }
  
  public void run()
  {
    if (this.iS.isEmpty()) {}
    for (Object localObject = new String[0];; localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { "ApolloHttpUtil httpResponseCallback http:", Long.valueOf(this.this$0.Ns), " url:", this.this$0.val$url, " method:", this.this$0.val$method });
      }
      this.this$0.a.getSavaWrapper().a(this.this$0.Ns, this.val$code, (String[])localObject, this.val$body);
      return;
      localObject = new ArrayList();
      Iterator localIterator = this.iS.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((ArrayList)localObject).add(localEntry.getKey());
        ((ArrayList)localObject).add(localEntry.getValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.11.1
 * JD-Core Version:    0.7.0.1
 */