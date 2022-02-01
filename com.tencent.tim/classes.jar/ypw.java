import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.widget.XListView;

public class ypw
  implements ypo.a
{
  public ypw(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void aE(boolean paramBoolean, int paramInt)
  {
    if ((this.a.mk) && (AddContactViewPagerTroopFragment.a(this.a) != null)) {
      AddContactViewPagerTroopFragment.b(this.a).d(this.a.xZ(), paramBoolean, null);
    }
    if (paramBoolean)
    {
      if (paramInt <= 0) {
        break label73;
      }
      this.a.hy.setVisibility(8);
      this.a.mListView.setVisibility(0);
    }
    label73:
    Object localObject;
    do
    {
      return;
      this.a.hy.setVisibility(0);
      this.a.mListView.setVisibility(8);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
      if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.a.uv.setImageDrawable((Drawable)localObject);
      this.a.Lp.setText(2131689857);
      this.a.Lq.setText(2131689863);
      this.a.Lr.setText(2131689858);
      this.a.Lr.setOnTouchListener(this.a.t);
      this.a.Lr.setOnClickListener(new ypx(this));
      localObject = this.a.hy.getParent();
    } while ((localObject == null) || (!(localObject instanceof ViewGroup)));
    ((ViewGroup)localObject).setBackgroundResource(2130839642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypw
 * JD-Core Version:    0.7.0.1
 */