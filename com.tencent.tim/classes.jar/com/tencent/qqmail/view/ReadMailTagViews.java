package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailTag;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.qmui.layout.QMUIFloatLayout;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;

public class ReadMailTagViews
  extends QMUIFloatLayout
{
  private final String fixEllipsize;
  private LayoutInflater inflater;
  private ArrayList<Object> mPreviousData = null;
  
  public ReadMailTagViews(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.inflater = LayoutInflater.from(paramContext);
    this.fixEllipsize = QMUIKit.ELLIPSIZE_FIXED;
  }
  
  private boolean isTheSame(ArrayList<Object> paramArrayList)
  {
    if ((this.mPreviousData == null) || (paramArrayList == null) || (paramArrayList.size() != this.mPreviousData.size())) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label69;
      }
      if (!((MailTag)paramArrayList.get(i)).equals((MailTag)this.mPreviousData.get(i))) {
        break;
      }
      i += 1;
    }
    label69:
    return true;
  }
  
  public void render(MailUI paramMailUI)
  {
    int i = 0;
    ArrayList localArrayList;
    if (paramMailUI.getInformation() == null)
    {
      localArrayList = null;
      if (!isTheSame(localArrayList)) {
        break label31;
      }
    }
    for (;;)
    {
      return;
      localArrayList = paramMailUI.getInformation().getTagList();
      break;
      label31:
      if (localArrayList == null) {}
      for (this.mPreviousData = null;; this.mPreviousData = new ArrayList(localArrayList))
      {
        removeAllViews();
        if ((paramMailUI != null) && (paramMailUI.getInformation() != null) && (paramMailUI.getInformation().getTagList() != null) && (paramMailUI.getInformation().getTagList().size() != 0)) {
          break;
        }
        setVisibility(8);
        return;
      }
      setVisibility(0);
      while (i < localArrayList.size())
      {
        paramMailUI = (MailTag)localArrayList.get(i);
        this.inflater.inflate(2131559516, this, true);
        TextView localTextView = (TextView)getChildAt(i);
        localTextView.setTextColor(QMUIHelper.getMailTagColorByColorId(getContext(), paramMailUI.getColor()));
        localTextView.setText(paramMailUI.getName() + this.fixEllipsize);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailTagViews
 * JD-Core Version:    0.7.0.1
 */