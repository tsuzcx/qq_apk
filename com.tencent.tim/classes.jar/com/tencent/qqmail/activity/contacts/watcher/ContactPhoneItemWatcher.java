package com.tencent.qqmail.activity.contacts.watcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.lang.ref.WeakReference;

public class ContactPhoneItemWatcher
  implements TextWatcher
{
  public static String PHONE_LINK_CHAR = "-";
  private String formatPhoneInput = "";
  private WeakReference<EditText> inputTextReference;
  private int lastLen = 0;
  
  public ContactPhoneItemWatcher(WeakReference<EditText> paramWeakReference)
  {
    this.inputTextReference = paramWeakReference;
    ((EditText)this.inputTextReference.get()).setTag(Boolean.valueOf(false));
  }
  
  public static String formatPhone(String paramString)
  {
    int i = paramString.length();
    if ((i > 11) || (i < 4)) {
      return paramString;
    }
    if (i == 11) {
      return paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, 7) + PHONE_LINK_CHAR + paramString.substring(7, i);
    }
    return paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, i);
  }
  
  private int getSelectEnd(boolean paramBoolean, int paramInt, String paramString)
  {
    int i = paramString.length();
    paramString = paramString.replace(PHONE_LINK_CHAR, "");
    this.formatPhoneInput = paramString;
    if (paramBoolean) {
      if (paramInt == i) {
        if (paramInt != 4) {}
      }
    }
    label721:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramInt;
                if (paramString.length() == 11)
                {
                  this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, 7) + PHONE_LINK_CHAR + paramString.substring(7, paramString.length()));
                  return paramInt + 2;
                }
                if (paramString.length() <= 11) {
                  break label721;
                }
                this.formatPhoneInput = paramString;
                return this.formatPhoneInput.length();
                if (paramString.length() != 11) {
                  break;
                }
                if (i == 12)
                {
                  if (paramInt == 8)
                  {
                    paramString = paramString.substring(0, 6) + paramString.substring(7, paramString.length());
                    this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));
                    return 7;
                  }
                  if (paramInt != 3) {
                    break label721;
                  }
                  paramString = paramString.substring(0, 2) + paramString.substring(3, paramString.length());
                  this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));
                  return 2;
                }
                this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, 7) + PHONE_LINK_CHAR + paramString.substring(7, paramString.length()));
                if (paramInt >= 8)
                {
                  if (paramInt + 2 > this.formatPhoneInput.length()) {
                    paramInt = this.formatPhoneInput.length();
                  }
                  for (;;)
                  {
                    return paramInt;
                    paramInt += 2;
                  }
                }
              } while (paramInt < 3);
              if (paramInt + 1 > this.formatPhoneInput.length()) {
                paramInt = this.formatPhoneInput.length();
              }
              for (;;)
              {
                return paramInt;
                paramInt += 1;
              }
              if (paramInt == 3)
              {
                paramString = paramString.substring(0, 2) + paramString.substring(3, paramString.length());
                if (paramString.length() <= 10) {}
                for (this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));; this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, 7) + PHONE_LINK_CHAR + paramString.substring(7, paramString.length()))) {
                  return 2;
                }
              }
              if (paramInt == 4)
              {
                this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));
                return paramInt;
              }
              if ((paramInt > 8) && (paramString.length() == 10))
              {
                this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));
                return paramInt - 1;
              }
              if (paramString.length() <= 3)
              {
                this.formatPhoneInput = paramString.substring(0, paramString.length());
                return paramInt;
              }
            } while (paramString.length() <= 3);
            if (paramString.length() > 10) {
              break label843;
            }
            if (paramInt == i) {
              break;
            }
            this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));
          } while (paramInt != 4);
          return paramInt + 1;
          this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, paramString.length()));
          return this.formatPhoneInput.length();
          if (paramString.length() != 11) {
            break;
          }
          this.formatPhoneInput = (paramString.substring(0, 3) + PHONE_LINK_CHAR + paramString.substring(3, 7) + PHONE_LINK_CHAR + paramString.substring(7, paramString.length()));
        } while (paramInt < 9);
        return paramInt + 1;
      } while ((paramBoolean) || (paramString.length() != 12));
      if (paramInt >= 10) {
        return paramInt - 2;
      }
    } while (paramInt < 5);
    label843:
    return paramInt - 1;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditText localEditText = (EditText)this.inputTextReference.get();
    if (localEditText != null)
    {
      localEditText.removeTextChangedListener(this);
      if (paramEditable.length() >= this.lastLen) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      int j = getSelectEnd(bool, localEditText.getSelectionEnd(), localEditText.getEditableText().toString());
      localEditText.setText(this.formatPhoneInput);
      this.lastLen = this.formatPhoneInput.length();
      int i = j;
      if (j > this.formatPhoneInput.length()) {
        i = this.formatPhoneInput.length();
      }
      localEditText.setSelection(i);
      localEditText.setTag(Boolean.valueOf(false));
      localEditText.addTextChangedListener(this);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.watcher.ContactPhoneItemWatcher
 * JD-Core Version:    0.7.0.1
 */