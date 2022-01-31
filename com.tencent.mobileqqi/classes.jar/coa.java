import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class coa
  extends FriendListObserver
{
  public coa(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    int i;
    if ((paramBoolean) && (3000 == DiscussionInfoCardActivity.a(this.a))) {
      i = 0;
    }
    for (;;)
    {
      if (i < DiscussionInfoCardActivity.a(this.a).getChildCount())
      {
        ImageView localImageView = (ImageView)DiscussionInfoCardActivity.a(this.a).getChildAt(i).findViewById(2131230940);
        String str = (String)localImageView.getTag();
        if ((str != null) && (str.equals(paramString))) {
          localImageView.setBackgroundDrawable(this.a.b.b(paramString));
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.a();
      DiscussionInfoCardActivity.a(this.a).setRightText(DiscussionInfoCardActivity.b(this.a));
      localIterator = DiscussionInfoCardActivity.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        localHashMap = (HashMap)localIterator.next();
        str = (String)localHashMap.get("memberUin");
        if ((str != null) && (str.compareTo(paramString1) == 0))
        {
          localHashMap.put("memberName", paramString2);
          if (DiscussionInfoCardActivity.a(this.a) != null) {
            DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
          }
        }
      }
    }
    while ((this.a.a == null) || (!this.a.a.isShowing()) || (this.a.isFinishing()))
    {
      Iterator localIterator;
      HashMap localHashMap;
      String str;
      return;
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     coa
 * JD-Core Version:    0.7.0.1
 */