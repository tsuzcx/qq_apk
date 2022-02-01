package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import anbk;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import aofk;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import lsz;
import ltn;
import org.json.JSONArray;
import org.json.JSONObject;

public class NativeUsersCommentsView
  extends LinearLayout
  implements IView
{
  private String afG;
  private JSONArray t;
  
  public NativeUsersCommentsView(Context paramContext)
  {
    super(paramContext);
  }
  
  private ReadInJoyYAFolderTextView a()
  {
    Object localObject = getChildAt(getChildCount() - 1);
    if ((localObject instanceof ReadInJoyYAFolderTextView))
    {
      ((View)localObject).setVisibility(0);
      return (ReadInJoyYAFolderTextView)localObject;
    }
    localObject = new ReadInJoyYAFolderTextView(getContext());
    addView((View)localObject);
    return localObject;
  }
  
  private void aNn()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView != null) {
        localView.setVisibility(8);
      }
      i += 1;
    }
  }
  
  private TextView b(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if ((localObject != null) && (!(localObject instanceof ReadInJoyYAFolderTextView)))
    {
      ((View)localObject).setVisibility(0);
      return (TextView)localObject;
    }
    localObject = new TextView(getContext());
    addView((View)localObject, paramInt);
    return localObject;
  }
  
  private void k(int paramInt, String paramString1, String paramString2)
  {
    TextView localTextView = b(paramInt);
    localTextView.setMaxLines(3);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    paramString1 = anbk.nn(paramString1);
    paramString2 = anbk.nn(paramString2);
    paramInt = paramString1.length();
    paramString1 = new aofk(paramString1 + ": " + paramString2, 7, 16);
    paramString2 = new ForegroundColorSpan(Color.parseColor("#D9000000"));
    StyleSpan localStyleSpan = new StyleSpan(1);
    paramString1.setSpan(paramString2, 0, paramInt, 33);
    paramString1.setSpan(localStyleSpan, 0, paramInt, 33);
    paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#D9000000")), paramInt, paramString1.length(), 33);
    localTextView.setTextSize(0, Utils.dp2px(14.0D));
    localTextView.setText(paramString1);
    localTextView.setPadding(0, 0, 0, aqnm.dip2px(2.0F));
    localTextView.setMaxLines(3);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void refresh()
  {
    int j = 0;
    aNn();
    int i = j;
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject2;
        if (this.t != null)
        {
          i = j;
          if (this.t.length() > 0)
          {
            i = 0;
            if (i >= this.t.length()) {
              break label254;
            }
            localObject1 = this.t.get(i);
            if (!(localObject1 instanceof JSONObject)) {
              break label247;
            }
            localObject2 = (JSONObject)localObject1;
            localObject1 = ((JSONObject)localObject2).getString("nick_name");
            localObject2 = ((JSONObject)localObject2).getString("comment");
            if ((localObject1 == null) || (localObject2 == null)) {
              break label247;
            }
            k(i, (String)localObject1, (String)localObject2);
            break label247;
          }
        }
        if (this.afG != null)
        {
          localObject1 = a();
          ((ReadInJoyYAFolderTextView)localObject1).setTextColor(Color.parseColor("#FF4D7CAF"));
          ((ReadInJoyYAFolderTextView)localObject1).setTextSize(0, Utils.dp2px(14.0D));
          if (i != 0) {
            ((ReadInJoyYAFolderTextView)localObject1).setPadding(0, aqnm.dip2px(5.0F), 0, 0);
          }
          localObject2 = new SpannableStringBuilder(this.afG);
          lsz locallsz = new lsz(-15504151, 16777215, 860716207);
          locallsz.setOnClickListener(new ltn(this));
          ((SpannableStringBuilder)localObject2).setSpan(locallsz, 0, ((SpannableStringBuilder)localObject2).length(), 33);
          ((ReadInJoyYAFolderTextView)localObject1).setText((CharSequence)localObject2);
          ((ReadInJoyYAFolderTextView)localObject1).setFocusable(false);
        }
        setPadding(aqnm.dip2px(12.0F), 0, aqnm.dip2px(12.0F), aqnm.dip2px(12.0F));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Q.readinjoy.proteus", 2, "refresh", localException);
        return;
      }
      label247:
      i += 1;
      continue;
      label254:
      i = 1;
    }
  }
  
  public void setCommentAllLink(String paramString)
  {
    this.afG = paramString;
  }
  
  public void setComments(JSONArray paramJSONArray)
  {
    this.t = paramJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeUsersCommentsView
 * JD-Core Version:    0.7.0.1
 */