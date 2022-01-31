package com.tencent.mobileqq.app;

import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.pb.PBStringField;

public class SecSigObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void b() {}
  
  public void c() {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        default: 
          return;
        }
      } while (!(paramObject instanceof signature.SignatureResult));
      paramObject = (signature.SignatureResult)paramObject;
    } while ((!paramObject.str_title.has()) || (!paramObject.str_content.has()) || (!paramObject.str_left_button.has()) || (!paramObject.str_right_button.has()) || (!paramObject.str_url.has()));
    a(paramObject.str_title.get(), paramObject.str_content.get(), paramObject.str_left_button.get(), paramObject.str_right_button.get(), paramObject.str_url.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSigObserver
 * JD-Core Version:    0.7.0.1
 */