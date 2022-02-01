package com.tencent.qqmail.card.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.common.base.Strings;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.view.QMAvatarView;

public class CardAvatarChooseView
  extends LinearLayout
{
  private QMAvatarView mAvatarView;
  private ImageView mCheckBox;
  private Context mContext;
  private TextView mNameTv;
  
  public CardAvatarChooseView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CardAvatarChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    setOrientation(1);
    LayoutInflater.from(this.mContext).inflate(2131558818, this, true);
    this.mAvatarView = ((QMAvatarView)findViewById(2131363175));
    this.mCheckBox = ((ImageView)findViewById(2131364587));
    this.mNameTv = ((TextView)findViewById(2131381440));
  }
  
  public QMAvatarView getAvatarView()
  {
    return this.mAvatarView;
  }
  
  public boolean getChecked()
  {
    return this.mCheckBox.isSelected();
  }
  
  public TextView getNameTv()
  {
    return this.mNameTv;
  }
  
  public void setAvatar(MailContact paramMailContact, boolean paramBoolean)
  {
    String str;
    if (!Strings.isNullOrEmpty(paramMailContact.getMark())) {
      str = paramMailContact.getMark();
    }
    for (;;)
    {
      Bitmap localBitmap = QMPrivateProtocolManager.getPhotoBitmapByEmail(paramMailContact.getAddress(), 3);
      if (localBitmap == null) {
        QMPrivateProtocolManager.sharedInstance().loadEmailIcon(paramMailContact.getAddress());
      }
      this.mAvatarView.setAvatarBitmap(ListViewHelper.generateAvatar(new QMAvatar(1), localBitmap, str));
      this.mNameTv.setText(str);
      this.mCheckBox.setSelected(paramBoolean);
      setTag(paramMailContact.getAddress());
      return;
      if (!Strings.isNullOrEmpty(paramMailContact.getNick())) {
        str = paramMailContact.getNick();
      } else if (!Strings.isNullOrEmpty(paramMailContact.getName())) {
        str = paramMailContact.getName();
      } else {
        str = this.mContext.getString(2131692061);
      }
    }
  }
  
  public void setAvatarView(QMAvatarView paramQMAvatarView)
  {
    this.mAvatarView = paramQMAvatarView;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.mCheckBox.setSelected(paramBoolean);
  }
  
  public void setNameTv(TextView paramTextView)
  {
    this.mNameTv = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardAvatarChooseView
 * JD-Core Version:    0.7.0.1
 */