import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atdu
  implements View.OnClickListener
{
  atdu(atdt paramatdt) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    Object localObject;
    boolean bool1;
    if ((paramView.getTag() instanceof atjv.a))
    {
      localObject = (atjv.a)paramView.getTag();
      if ((!this.a.cLe) || (paramView.getId() == 2131364710)) {
        break label587;
      }
      if (!this.a.cLf) {
        break label177;
      }
      if (!((atjv.a)localObject).checkBox.isChecked()) {
        break label138;
      }
      atiz.clearSelected();
      this.a.mSelectedPosition = -1;
      this.a.notifyDataSetChanged();
      if (atdt.a(this.a) != null)
      {
        atdt.a(this.a).etm();
        localObject = atdt.a(this.a);
        if (atiz.Ou() < atiz.cXX) {
          break label172;
        }
        bool1 = true;
        label122:
        ((atdt.a)localObject).Vu(bool1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label138:
      atiz.clearSelected();
      this.a.mSelectedPosition = ((atjv.a)localObject).position;
      atiz.a(((atjv.a)localObject).a);
      this.a.notifyDataSetChanged();
      break;
      label172:
      bool1 = false;
      break label122;
      label177:
      if (!((atjv.a)localObject).isSelected) {
        bool1 = true;
      }
      for (;;)
      {
        if (atdt.a(this.a) != null)
        {
          if ((((atjv.a)localObject).a.getCloudFileType() == 2) && (this.a.mActionType == 6))
          {
            QQToast.a(this.a.mContext, 1, 2131719432, 0).show(this.a.mContext.getResources().getDimensionPixelSize(2131299627));
            break;
            bool1 = false;
            continue;
          }
          if ((((atjv.a)localObject).a.getCloudFileType() == 2) || (((atjv.a)localObject).a.getCloudFileType() == 0) || (((atjv.a)localObject).a.getCloudFileType() == 7) || (((atjv.a)localObject).a.getCloudFileType() == 9) || ((((atjv.a)localObject).a.getCloudFileType() == 1) && (this.a.mode == 0))) {
            if (!bool1) {
              break label574;
            }
          }
        }
      }
      for (boolean bool2 = atiz.a(((atjv.a)localObject).a);; bool2 = true)
      {
        ((atjv.a)localObject).isSelected = bool1;
        if ((((atjv.a)localObject).checkBox != null) && (bool2)) {
          ((atjv.a)localObject).checkBox.setChecked(((atjv.a)localObject).isSelected);
        }
        if (atdt.a(this.a) != null)
        {
          atdt.a(this.a).etm();
          atdt.a locala = atdt.a(this.a);
          bool1 = bool3;
          if (atiz.Ou() >= atiz.cXX) {
            bool1 = true;
          }
          locala.Vu(bool1);
        }
        if (((((atjv.a)localObject).a.getCloudFileType() != 3) && (((((atjv.a)localObject).a.getCloudFileType() != 1) && (((atjv.a)localObject).a.getCloudFileType() != 8) && (((atjv.a)localObject).a.getCloudFileType() != 12) && (((atjv.a)localObject).a.getCloudFileType() != 11)) || ((this.a.cLe) && (this.a.mode == 0)))) || (this.a.onClickListener == null) || (!((atjv.a)localObject).a.isClickable())) {
          break;
        }
        this.a.onClickListener.onClick(paramView);
        break;
        label574:
        atiz.b(((atjv.a)localObject).a);
      }
      label587:
      if ((this.a.onClickListener != null) && (((atjv.a)localObject).a.isClickable())) {
        this.a.onClickListener.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdu
 * JD-Core Version:    0.7.0.1
 */