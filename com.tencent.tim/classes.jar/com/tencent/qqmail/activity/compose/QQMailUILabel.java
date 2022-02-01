package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QQMailUILabel
  extends LinearLayout
{
  private TextView contentTV;
  private Object otherInfo;
  private TextView prefixTV;
  
  public QQMailUILabel(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQMailUILabel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextView getContentTV()
  {
    return this.contentTV;
  }
  
  public Object getOtherInfo()
  {
    return this.otherInfo;
  }
  
  public TextView getPrefixTV()
  {
    return this.prefixTV;
  }
  
  public String getTitle()
  {
    return this.contentTV.getText().toString();
  }
  
  public void init()
  {
    this.prefixTV = ((TextView)findViewById(2131365192));
    this.contentTV = ((TextView)findViewById(2131365191));
  }
  
  public void setContentTV(TextView paramTextView)
  {
    this.contentTV = paramTextView;
  }
  
  public void setOtherInfo(Object paramObject)
  {
    this.otherInfo = paramObject;
  }
  
  public void setPrefixTV(TextView paramTextView)
  {
    this.prefixTV = paramTextView;
  }
  
  public void setTitle(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.contentTV.setText(str);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("QQMailUILabel: ");
    if (this.prefixTV != null) {}
    for (Object localObject = this.prefixTV.getText();; localObject = "null") {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QQMailUILabel
 * JD-Core Version:    0.7.0.1
 */