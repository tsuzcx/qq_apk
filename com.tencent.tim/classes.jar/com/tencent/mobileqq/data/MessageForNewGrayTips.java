package com.tencent.mobileqq.data;

import aczw;
import aezw;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import anot;
import aqhv;
import aqik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.a;
import java.util.ArrayList;
import java.util.Iterator;

public class MessageForNewGrayTips
  extends ChatMessage
{
  public ArrayList<GrayTipsSpan> spans;
  
  public void buildTextView(QQAppInterface paramQQAppInterface, TextView paramTextView)
  {
    if (TextUtils.isEmpty(this.msg)) {
      return;
    }
    paramQQAppInterface = new SpannableString(this.msg);
    if ((this.spans != null) && (this.spans.size() != 0))
    {
      Iterator localIterator = this.spans.iterator();
      while (localIterator.hasNext())
      {
        GrayTipsSpan localGrayTipsSpan = (GrayTipsSpan)localIterator.next();
        try
        {
          paramQQAppInterface.setSpan(new DatingCommentTextView.a(new aezw(this, localGrayTipsSpan), -14782465), localGrayTipsSpan.begin, localGrayTipsSpan.end, 33);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    paramTextView.setText(paramQQAppInterface);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public void click(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Object localObject = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), paramString);
      if (localObject != null) {
        ((aqhv)localObject).ace();
      }
      while ((this.msgtype == -2037) && ((paramView.getContext() instanceof BaseActivity)))
      {
        anot.a(((BaseActivity)paramView.getContext()).app, "CliOper", "", "", "0X80060B7", "0X80060B7", 0, 0, "", "", "", "");
        return;
        localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramString));
        paramView.getContext().startActivity((Intent)localObject);
      }
    }
  }
  
  protected void doParse()
  {
    try
    {
      GrayTipsInfo localGrayTipsInfo = (GrayTipsInfo)aczw.c(this.msgData);
      if (localGrayTipsInfo != null)
      {
        this.msg = localGrayTipsInfo.text;
        this.spans = localGrayTipsInfo.spans;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void prewrite()
  {
    GrayTipsInfo localGrayTipsInfo;
    if (this.msg != null)
    {
      localGrayTipsInfo = new GrayTipsInfo();
      localGrayTipsInfo.text = this.msg;
      localGrayTipsInfo.spans = this.spans;
    }
    try
    {
      this.msgData = aczw.b(localGrayTipsInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void updateMsgData()
  {
    prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNewGrayTips
 * JD-Core Version:    0.7.0.1
 */