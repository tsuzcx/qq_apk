package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.utilities.common.CommUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ComposeAddrView
  extends LinearLayout
  implements MailAddrsViewControl.MailAddrsViewControlCallback
{
  private static String TAG = "ComposeAddrView";
  private MailAddrsViewControl addrsViewControl;
  private ComposeAddrViewCallback callback;
  private boolean hasAddImage;
  private int iType;
  private boolean isGroup;
  private ImageView mContactImage;
  private int mUnExpandHeight;
  private TextView prefixTV;
  private int totalWidth;
  
  public ComposeAddrView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComposeAddrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void initViews()
  {
    this.prefixTV = ((TextView)findViewById(2131365135));
    this.addrsViewControl = ((MailAddrsViewControl)findViewById(2131365132));
    this.addrsViewControl.setTotalWidth(this.totalWidth - (int)getResources().getDimension(2131296987) - (int)getResources().getDimension(2131296987) - (int)getResources().getDimension(2131296970));
    this.addrsViewControl.setDropDownListAnchorId(getId());
    MailAddrsViewControl localMailAddrsViewControl = this.addrsViewControl;
    if (!this.isGroup) {}
    for (boolean bool = true;; bool = false)
    {
      localMailAddrsViewControl.init(bool);
      this.addrsViewControl.setCallback(this);
      this.mContactImage = ((ImageView)findViewById(2131365134));
      this.mContactImage.setVisibility(4);
      this.mContactImage.setOnClickListener(new ComposeAddrView.1(this));
      setOnClickListener(new ComposeAddrView.2(this));
      return;
    }
  }
  
  private boolean isGroup()
  {
    return this.isGroup;
  }
  
  private void setmContactImage(ImageView paramImageView)
  {
    this.mContactImage = paramImageView;
  }
  
  public void addContact(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if ((this.isGroup) && ((paramObject instanceof MailGroupContact)))
      {
        paramObject = (MailGroupContact)paramObject;
        this.addrsViewControl.insertMailAddr(paramObject);
        removeHotContactTableView();
        return;
      }
    } while (!(paramObject instanceof MailContact));
    paramObject = (MailContact)paramObject;
    this.addrsViewControl.insertMailAddr(paramObject);
    removeHotContactTableView();
  }
  
  public void addrControlScrollChanged(MailAddrsViewControl paramMailAddrsViewControl)
  {
    if (this.callback != null) {
      this.callback.addrViewScrollChanged(this);
    }
  }
  
  public void addrControlTextChanged(MailAddrsViewControl paramMailAddrsViewControl, String paramString)
  {
    if (this.callback != null) {
      this.callback.addrViewTextChanged(this, paramString);
    }
  }
  
  public void adjustMailAddrsViewControl()
  {
    this.addrsViewControl.adjustinputATVWidth();
  }
  
  public void changeDefaultSenderAccount(Account paramAccount)
  {
    MailAddrsViewControl localMailAddrsViewControl = getAddrsViewControl();
    if (localMailAddrsViewControl != null) {
      localMailAddrsViewControl.setDefaultSenderAccount(paramAccount);
    }
  }
  
  public void clickedAddGroupContactButton(MailAddrsViewControl paramMailAddrsViewControl)
  {
    if ((this.addrsViewControl.isEnabled()) && (this.callback != null)) {
      this.callback.clickedAddGroupContactButton(this);
    }
  }
  
  public void enterForClearFocus(MailAddrsViewControl paramMailAddrsViewControl, boolean paramBoolean)
  {
    if (this.callback != null) {
      this.callback.enterForClearFocus(this, paramBoolean);
    }
  }
  
  public MailAddrsViewControl getAddrsViewControl()
  {
    return this.addrsViewControl;
  }
  
  public int getAutoCompleteTextViewHeight()
  {
    return this.addrsViewControl.getAutoCompleteTextViewHeight();
  }
  
  public ComposeAddrViewCallback getCallback()
  {
    return this.callback;
  }
  
  public ArrayList<Object> getContactList()
  {
    ArrayList localArrayList2 = new ArrayList();
    if (this.isGroup) {}
    for (ArrayList localArrayList1 = this.addrsViewControl.getMailGroupAddrs();; localArrayList1 = this.addrsViewControl.getMailAddrs())
    {
      if (localArrayList1 != null) {
        localArrayList2.addAll(localArrayList1);
      }
      return localArrayList2;
    }
  }
  
  public TextView getPrefixTV()
  {
    return this.prefixTV;
  }
  
  public int getUnExpandHeight()
  {
    return this.mUnExpandHeight;
  }
  
  public int getiType()
  {
    return this.iType;
  }
  
  public ImageView getmContactImage()
  {
    return this.mContactImage;
  }
  
  public boolean hasContact()
  {
    if (this.isGroup)
    {
      if (this.addrsViewControl.getMailGroupAddrs().size() <= 0) {}
    }
    else
    {
      while ((this.addrsViewControl.getMailAddrs().size() > 0) || (!this.addrsViewControl.isInputAreaEmpty())) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public boolean hasFocusCursor()
  {
    return this.addrsViewControl.getInputATV().isFocused();
  }
  
  public Collection<? extends Object> inValidateContacts()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getContactList().iterator();
    label92:
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      String str = "";
      if ((localObject instanceof MailContact)) {
        str = ((MailContact)localObject).getAddress();
      }
      for (;;)
      {
        if (CommUtils.checkMailAddress(str)) {
          break label92;
        }
        localArrayList.add(localObject);
        break;
        if ((localObject instanceof MailGroupContact)) {
          str = ((MailGroupContact)localObject).getAddress();
        }
      }
    }
    return localArrayList;
  }
  
  public void init(boolean paramBoolean)
  {
    this.isGroup = paramBoolean;
    initViews();
  }
  
  public void inputClickChanged(MailAddrsViewControl paramMailAddrsViewControl)
  {
    if (this.callback != null) {
      this.callback.inputClickChanged(this);
    }
  }
  
  public void inputFocusChanged(MailAddrsViewControl paramMailAddrsViewControl, boolean paramBoolean)
  {
    if (this.callback != null) {
      this.callback.inputFocusChanged(this, paramBoolean);
    }
  }
  
  public boolean isHasAddImage()
  {
    return this.hasAddImage;
  }
  
  public boolean isSetFocused()
  {
    return this.addrsViewControl.isFocused();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mUnExpandHeight == 0) {
      this.mUnExpandHeight = paramInt2;
    }
    while ((this.addrsViewControl == null) || (this.addrsViewControl.isExpanded())) {
      return;
    }
    this.mUnExpandHeight = paramInt2;
  }
  
  public void removeHotContactTableView()
  {
    if (this.addrsViewControl.getInputATV() != null) {
      this.addrsViewControl.getInputATV().setText("");
    }
  }
  
  public void resetFocusCursor()
  {
    this.addrsViewControl.getInputATV().requestFocus();
  }
  
  public void setAddrsViewControl(MailAddrsViewControl paramMailAddrsViewControl)
  {
    this.addrsViewControl = paramMailAddrsViewControl;
  }
  
  public void setCallback(ComposeAddrViewCallback paramComposeAddrViewCallback)
  {
    this.callback = paramComposeAddrViewCallback;
  }
  
  public void setFocused(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.addrsViewControl.requestInputAreaFocus();
      return;
    }
    this.addrsViewControl.clearInputAreaFocus();
  }
  
  public void setHasAddImage(boolean paramBoolean)
  {
    this.hasAddImage = paramBoolean;
  }
  
  public void setPrefixTV(TextView paramTextView)
  {
    this.prefixTV = paramTextView;
  }
  
  public void setTotalWidth(int paramInt)
  {
    this.totalWidth = paramInt;
  }
  
  public void setUnChangeable()
  {
    setEnabled(false);
    this.prefixTV.setEnabled(false);
    this.addrsViewControl.setEnabled(false);
    this.mContactImage.setEnabled(false);
  }
  
  public void setiType(int paramInt)
  {
    this.iType = paramInt;
  }
  
  public String toString()
  {
    if (this.prefixTV == null) {
      return super.toString();
    }
    return "ComposeAddrView: " + this.prefixTV.getText();
  }
  
  public void unRegisterListener()
  {
    this.addrsViewControl.unRegisterListener();
  }
  
  public static abstract interface ComposeAddrViewCallback
  {
    public abstract void addrViewScrollChanged(ComposeAddrView paramComposeAddrView);
    
    public abstract void addrViewTextChanged(ComposeAddrView paramComposeAddrView, String paramString);
    
    public abstract void clickAddContactButton(ComposeAddrView paramComposeAddrView);
    
    public abstract void clickedAddGroupContactButton(ComposeAddrView paramComposeAddrView);
    
    public abstract void enterForClearFocus(ComposeAddrView paramComposeAddrView, boolean paramBoolean);
    
    public abstract void inputClickChanged(ComposeAddrView paramComposeAddrView);
    
    public abstract void inputFocusChanged(ComposeAddrView paramComposeAddrView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeAddrView
 * JD-Core Version:    0.7.0.1
 */