import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;

public class pxb
  extends pwx
{
  public pxb(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void b(ShareGroupItem paramShareGroupItem)
  {
    String str;
    Object localObject;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramShareGroupItem == null) || (TextUtils.isEmpty(paramShareGroupItem.getName())))
    {
      str = acfp.m(2131714388);
      this.titleTextView.setText(str);
      localObject = (qph)psx.a(24);
      i = this.mA.getContext().getResources().getDimensionPixelSize(2131298960);
      localLayoutParams = (RelativeLayout.LayoutParams)this.mA.getLayoutParams();
      if (localLayoutParams != null) {
        break label116;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      this.mA.setLayoutParams(localLayoutParams);
      label91:
      if (paramShareGroupItem != null) {
        break label131;
      }
      this.mA.setImageDrawable(((qph)localObject).at());
    }
    label116:
    do
    {
      return;
      str = paramShareGroupItem.getName();
      break;
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      break label91;
      localObject = ((qph)localObject).a(paramShareGroupItem.headerUnionIdList, str);
      this.mA.setImageDrawable((Drawable)localObject);
    } while (!QLog.isColorLevel());
    label131:
    paramShareGroupItem = new StringBuilder("nickname = ").append(str).append(", headerUnionIdList = ").append(paramShareGroupItem.headerUnionIdList);
    QLog.e("zivonxxx", 2, "ShareGroupViewHolder: " + paramShareGroupItem.toString());
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    this.itemView.setTag(parampuh.unionId);
    ShareGroupItem localShareGroupItem = ((qqe)psx.a(7)).a(parampuh.unionId);
    b(localShareGroupItem);
    if (localShareGroupItem == null) {
      new pxm(parampuh.unionId, String.valueOf(System.currentTimeMillis())).sendRequest();
    }
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "ShareGroupViewHolder groupItem = " + localShareGroupItem + ", unionId = " + parampuh.unionId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxb
 * JD-Core Version:    0.7.0.1
 */