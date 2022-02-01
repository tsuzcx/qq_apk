import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.c;
import java.util.List;

public class ymt
  implements Handler.Callback
{
  public ymt(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    switch (paramMessage.arg2)
    {
    }
    for (;;)
    {
      this.this$0.mIsLoading = false;
      break;
      switch (paramMessage.arg1)
      {
      default: 
        break;
      case 20: 
        this.this$0.KP.setText(acfp.m(2131715996));
        paramMessage = TroopMemberHistoryFragment.a(this.this$0).getContext().getResources();
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(320.0F, paramMessage);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(177.5F, paramMessage);
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
        paramMessage = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171229/e4f73825907a4cdeb29db9c6688cd82c.png", (URLDrawable.URLDrawableOptions)localObject);
        localObject = (ImageView)this.this$0.mEmptyView.findViewById(2131379638);
        ((ImageView)localObject).setImageDrawable(paramMessage);
        ((ImageView)localObject).setVisibility(0);
        this.this$0.mEmptyView.setVisibility(0);
        continue;
        if ((paramMessage.obj instanceof List))
        {
          this.this$0.a.aa((List)paramMessage.obj);
          this.this$0.a.notifyDataSetChanged();
        }
        switch (paramMessage.arg1)
        {
        default: 
          break;
        case 20: 
          this.this$0.mEmptyView.setVisibility(8);
          continue;
          if (paramMessage.arg1 == 20)
          {
            this.this$0.KP.setText(2131699804);
            this.this$0.mEmptyView.setVisibility(0);
          }
          break;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymt
 * JD-Core Version:    0.7.0.1
 */