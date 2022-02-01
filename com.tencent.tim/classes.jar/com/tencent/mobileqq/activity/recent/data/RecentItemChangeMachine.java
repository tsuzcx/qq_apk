package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import apqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import org.json.JSONException;
import org.json.JSONObject;

public class RecentItemChangeMachine
  extends RecentUserBaseData
{
  boolean isRead = true;
  
  public RecentItemChangeMachine(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    this.mUnreadFlag = 2;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    String str;
    if ((this.mUser.msg != null) && ((this.mUser.msg instanceof String)))
    {
      str = (String)this.mUser.msg;
      if (str == null) {}
    }
    try
    {
      this.isRead = new JSONObject(str).getBoolean("isRead");
      if (this.isRead)
      {
        i = 0;
        this.mUnreadNum = i;
        this.mDisplayTime = this.mUser.showUpTime;
        paramQQAppInterface = (apqx)paramQQAppInterface.getManager(183);
        if (TextUtils.isEmpty(this.mTitleName))
        {
          if (!TextUtils.isEmpty(paramQQAppInterface.title)) {
            break label181;
          }
          this.mTitleName = paramContext.getResources().getString(2131699504);
        }
        if (!TextUtils.isEmpty(paramQQAppInterface.description)) {
          break label192;
        }
        this.mLastMsg = paramContext.getResources().getString(2131699503);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        int i = 1;
        continue;
        label181:
        this.mTitleName = paramQQAppInterface.title;
      }
      label192:
      this.mLastMsg = paramQQAppInterface.description;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChangeMachine
 * JD-Core Version:    0.7.0.1
 */