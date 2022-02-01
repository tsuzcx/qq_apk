import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xbs
  implements View.OnClickListener
{
  xbs(xbr paramxbr) {}
  
  public void onClick(View paramView)
  {
    Object localObject = wja.a(paramView);
    if ((localObject instanceof MessageForFoldMsgGrayTips))
    {
      ((MessageForFoldMsgGrayTips)localObject).isOpen = true;
      xbr.a locala = (xbr.a)wja.a(paramView);
      locala.mTextView.setText(((MessageForFoldMsgGrayTips)localObject).getShowMsgContent(this.a.app, this.a.mContext));
      localObject = locala.mTextView.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != wja.dp2px(10.0F, this.a.mContext.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = wja.dp2px(10.0F, this.a.mContext.getResources());
        }
      }
      locala.sY.setVisibility(8);
      locala.layout.requestLayout();
      anot.a(this.a.app, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbs
 * JD-Core Version:    0.7.0.1
 */