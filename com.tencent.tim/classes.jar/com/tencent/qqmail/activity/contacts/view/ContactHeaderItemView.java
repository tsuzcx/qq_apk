package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.view.QMAvatarView;

public class ContactHeaderItemView
  extends ContactBaseItemView
{
  private QMAvatarView avatarView;
  private ImageView iconClear;
  private boolean isEditMode;
  private EditText nameEditText;
  private TextView nameTextView;
  private ImageView vipSignView;
  
  public ContactHeaderItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactHeaderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactHeaderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactHeaderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public QMAvatarView getAvatarView()
  {
    return this.avatarView;
  }
  
  public EditText getNameEditText()
  {
    return this.nameEditText;
  }
  
  public String getNameText()
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.nameTextView != null)
    {
      localObject1 = localObject2;
      if (this.nameTextView.getVisibility() == 0) {
        localObject1 = this.nameTextView.getText().toString();
      }
    }
    localObject2 = localObject1;
    if (this.nameEditText != null)
    {
      localObject2 = localObject1;
      if (this.nameEditText.getVisibility() == 0) {
        localObject2 = this.nameEditText.getText().toString();
      }
    }
    return localObject2;
  }
  
  public TextView getNameTextView()
  {
    return this.nameTextView;
  }
  
  public ImageView getVipSignView()
  {
    return this.vipSignView;
  }
  
  protected int initLayout()
  {
    return 2131559094;
  }
  
  protected void initViews()
  {
    this.avatarView = ((QMAvatarView)findViewById(2131365269));
    this.vipSignView = ((ImageView)findViewById(2131365272));
    this.nameTextView = ((TextView)findViewById(2131365270));
    this.nameEditText = ((EditText)findViewById(2131365271));
    this.iconClear = ((ImageView)findViewById(2131365280));
  }
  
  public void setAvatarViewEmail(String paramString1, String paramString2)
  {
    if (this.avatarView != null)
    {
      int j = 0;
      int i = j;
      if (paramString2 != null)
      {
        i = j;
        if (!paramString2.isEmpty())
        {
          Bitmap localBitmap = QMPrivateProtocolManager.getPhotoBitmapByEmail(paramString2, 2);
          i = j;
          if (localBitmap != null)
          {
            this.avatarView.setAvatar(localBitmap, paramString2);
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.avatarView.setAvatar(null, paramString1);
      }
      QMPrivateProtocolManager.sharedInstance().loadEmailIcon(paramString2);
    }
  }
  
  public void setEditModel(boolean paramBoolean)
  {
    this.isEditMode = paramBoolean;
    if (paramBoolean)
    {
      if (this.nameEditText != null)
      {
        this.nameEditText.setVisibility(0);
        this.nameEditText.addTextChangedListener(new ContactHeaderItemView.1(this));
        this.nameEditText.setOnFocusChangeListener(new ContactHeaderItemView.2(this));
      }
      if (this.nameTextView != null) {
        this.nameTextView.setVisibility(8);
      }
      this.iconClear.setOnClickListener(new ContactHeaderItemView.3(this));
    }
    do
    {
      return;
      if (this.nameEditText != null) {
        this.nameEditText.setVisibility(8);
      }
    } while (this.nameTextView == null);
    this.nameTextView.setVisibility(0);
    this.nameTextView.setLongClickable(true);
    this.nameTextView.setOnLongClickListener(new ContactHeaderItemView.4(this));
  }
  
  public void setNameText(String paramString)
  {
    if ((this.nameTextView != null) && (this.nameTextView.getVisibility() == 0)) {
      this.nameTextView.setText(paramString);
    }
    if ((this.nameEditText != null) && (paramString != null) && (!paramString.isEmpty()) && (this.nameEditText.getVisibility() == 0))
    {
      this.nameEditText.setText(paramString);
      this.nameEditText.setSelection(paramString.length());
    }
  }
  
  public void setVipSign(boolean paramBoolean)
  {
    if (this.vipSignView != null)
    {
      if (this.isEditMode) {
        this.vipSignView.setVisibility(4);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.vipSignView.setVisibility(0);
      return;
    }
    this.vipSignView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView
 * JD-Core Version:    0.7.0.1
 */