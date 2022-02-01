package com.tencent.qqmail.view;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.qqmail.account.model.AccountType;
import java.util.List;

public class EmailEditText
  extends EditText
{
  public static final String AT = "@";
  public String entrance;
  public int grayLength;
  public String suffix;
  public boolean triggerBySetText = false;
  public int userInputLength;
  public String userInputString;
  
  public EmailEditText(Context paramContext)
  {
    super(paramContext);
    addListener();
  }
  
  public EmailEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    addListener();
  }
  
  public EmailEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    addListener();
  }
  
  private void addListener()
  {
    addTextChangedListener(new EmailTextWatcher(this));
  }
  
  private boolean checkEntrance()
  {
    return (this.entrance != null) && (!this.entrance.equals("")) && (!this.entrance.equals(AccountType.other.toString())) && (!this.entrance.equals(AccountType.exmail.toString())) && (!this.entrance.equals(AccountType.exchange.toString()));
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (!checkEntrance()) {}
    String str;
    do
    {
      do
      {
        return;
      } while (this.triggerBySetText);
      str = getText().toString();
    } while ((str == null) || (str.equals("")) || (!str.contains("@")));
    int k = str.split("@")[1].length() + 1;
    if (str != null) {}
    for (int i = str.length();; i = 0)
    {
      if (paramInt1 == paramInt2)
      {
        if (i - paramInt2 < k)
        {
          if (this.grayLength >= k)
          {
            paramInt1 = i - k;
            if (paramInt1 - paramInt2 <= 0) {
              break label132;
            }
          }
          for (;;)
          {
            setSelection(paramInt2);
            return;
            paramInt1 = str.length() - this.grayLength;
            break;
            label132:
            paramInt2 = paramInt1;
          }
        }
        super.onSelectionChanged(paramInt1, paramInt2);
        return;
      }
      if ((this.userInputString != null) && (this.userInputString.contains("@"))) {
        i = this.userInputLength;
      }
      while (paramInt1 + 1 >= i)
      {
        paramInt1 = j;
        if (i - 1 > 0) {
          paramInt1 = i - 1;
        }
        j = paramInt2;
        if (paramInt2 > i) {
          j = i;
        }
        setSelection(paramInt1, j);
        return;
        if (str.indexOf("@") > 0) {
          i = str.indexOf("@");
        } else {
          i = 0;
        }
      }
      if (paramInt2 > i) {}
      for (;;)
      {
        setSelection(paramInt1, i);
        return;
        i = paramInt2;
      }
    }
  }
  
  public void setAllBlack()
  {
    this.userInputString = getText().toString();
    this.userInputLength = this.userInputString.length();
    this.grayLength = 0;
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-16777216);
    SpannableString localSpannableString = new SpannableString(this.userInputString);
    localSpannableString.setSpan(localForegroundColorSpan, 0, localSpannableString.length(), 33);
    setText(localSpannableString);
  }
  
  public void setEntrance(String paramString)
  {
    this.entrance = paramString;
  }
  
  public void setSelectionToEnd()
  {
    if ((getText() != null) && (getText().toString() != null))
    {
      this.userInputString = getText().toString();
      this.userInputLength = this.userInputString.length();
      this.grayLength = 0;
      setSelection(this.userInputLength);
    }
  }
  
  class EmailTextWatcher
    implements TextWatcher
  {
    String afterStr;
    EmailEditText e;
    
    public EmailTextWatcher(EmailEditText paramEmailEditText)
    {
      this.e = paramEmailEditText;
    }
    
    private String findSuffix(String paramString1, String paramString2)
    {
      paramString2 = Suffix.get(paramString2);
      int i = 0;
      while (i < paramString2.size())
      {
        if (((String)paramString2.get(i)).startsWith(paramString1)) {
          return (String)paramString2.get(i);
        }
        i += 1;
      }
      return "";
    }
    
    private void setSpannableEmail(String paramString, int paramInt)
    {
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-3355444);
      SpannableString localSpannableString = new SpannableString(paramString);
      localSpannableString.setSpan(localForegroundColorSpan, paramString.length() - paramInt, paramString.length(), 33);
      paramInt = this.e.getSelectionStart();
      this.e.triggerBySetText = true;
      this.e.setText(localSpannableString);
      this.e.setSelection(paramInt);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (!EmailEditText.this.checkEntrance()) {}
      do
      {
        return;
        if (this.e.triggerBySetText)
        {
          this.e.triggerBySetText = false;
          return;
        }
        this.afterStr = paramEditable.toString();
      } while (this.afterStr.equals(""));
      paramEditable = this.afterStr;
      String str1;
      if (this.afterStr.contains("@"))
      {
        str1 = this.afterStr.split("@")[0];
        EmailEditText.this.userInputString = this.afterStr.substring(0, EmailEditText.this.userInputLength);
        if (EmailEditText.this.userInputString.equals(""))
        {
          paramEditable = "";
          EmailEditText.this.grayLength = 0;
        }
      }
      for (;;)
      {
        setSpannableEmail(paramEditable, EmailEditText.this.grayLength);
        return;
        if (EmailEditText.this.userInputString.contains("@")) {}
        String str2;
        for (paramEditable = EmailEditText.this.userInputString.substring(EmailEditText.this.userInputString.indexOf("@"), EmailEditText.this.userInputString.length());; paramEditable = "")
        {
          str2 = findSuffix(paramEditable, EmailEditText.this.entrance);
          if (!str2.equals("")) {
            break label246;
          }
          paramEditable = str1 + paramEditable;
          EmailEditText.this.grayLength = 0;
          break;
        }
        label246:
        paramEditable = str1 + str2;
        EmailEditText.this.grayLength = (paramEditable.length() - EmailEditText.this.userInputLength);
        continue;
        EmailEditText.this.grayLength = EmailEditText.this.suffix.length();
        paramEditable = this.afterStr.substring(0, EmailEditText.this.userInputLength) + EmailEditText.this.suffix;
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!EmailEditText.this.checkEntrance()) {}
      while (EmailEditText.this.triggerBySetText) {
        return;
      }
      paramCharSequence = EmailEditText.this;
      paramCharSequence.userInputLength += paramInt3 - paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.EmailEditText
 * JD-Core Version:    0.7.0.1
 */