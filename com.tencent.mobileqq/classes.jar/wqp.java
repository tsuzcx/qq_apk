import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import java.util.List;

public class wqp
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bgya a;
  private AEBottomListScrollView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  
  public wqp(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131313245));
    this.e = ((ImageView)paramView.findViewById(2131313253));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131313259));
    this.b = ((ImageView)paramView.findViewById(2131313252));
    this.c = ((ImageView)paramView.findViewById(2131313260));
    this.d = ((ImageView)paramView.findViewById(2131313255));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131313297));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView = paramAEBottomListScrollView;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)wql.a().get(5);
    }
    if (this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)wql.a().get(6);
    }
    if (wql.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)wql.a().get(paramInt);
      paramInt = (paramInt - 1 - 1) % 4;
      continue;
      paramInt = (paramInt - 1) % 4;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.b != null) {
              this.b.setVisibility(0);
            }
          } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          return;
          if (this.b != null) {
            this.b.setVisibility(4);
          }
        } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      } while (this.b == null);
      this.b.setVisibility(8);
      return;
    case 3: 
      if (this.d != null) {
        this.d.setVisibility(0);
      }
      if (this.jdField_a_of_type_Bgya.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
    }
    if (this.d != null) {
      this.d.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  public void a(bgya parambgya)
  {
    this.jdField_a_of_type_Bgya = parambgya;
    if (this.jdField_a_of_type_Bgya != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))) {
        break label215;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      if (!this.jdField_a_of_type_Bgya.b()) {
        break label593;
      }
      this.c.setVisibility(0);
      this.c.setImageResource(this.jdField_a_of_type_Bgya.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      parambgya = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131311070, parambgya);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131311040, Boolean.valueOf(false));
      vms.a(this.jdField_a_of_type_AndroidWidgetImageView, parambgya, vms.a(this.itemView.getContext(), 54.0F), vms.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849408), null);
      return;
      label215:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setImageResource(2130843690);
        break;
      }
      if (this.jdField_a_of_type_Bgya.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setTag(2131311070, this.jdField_a_of_type_Bgya.b);
        this.e.setTag(2131311040, Boolean.valueOf(false));
        vms.a(this.e, this.jdField_a_of_type_Bgya.b, vms.a(this.itemView.getContext(), 54.0F), vms.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849408), null);
        this.e.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        this.c.setImageResource(2130845019);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.e.setVisibility(0);
      this.e.setTag(2131311070, this.jdField_a_of_type_Bgya.b);
      this.e.setTag(2131311040, Boolean.valueOf(false));
      vms.a(this.e, this.jdField_a_of_type_Bgya.b, vms.a(this.itemView.getContext(), 54.0F), vms.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849408), null);
      if (this.jdField_a_of_type_Bgya.d) {
        a(2);
      }
      for (;;)
      {
        this.c.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Bgya.e) {
          a(1);
        } else {
          a(0);
        }
      }
      label593:
      if (this.jdField_a_of_type_Bgya.a())
      {
        this.c.setVisibility(0);
        this.c.setImageResource(2130845019);
      }
      else
      {
        this.c.setVisibility(8);
      }
    }
  }
  
  public void b(bgya parambgya)
  {
    this.jdField_a_of_type_Bgya = parambgya;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView != null) && (i >= 0)) {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Bgya != null) && ("call_material_id".equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString)))
    {
      bhci.a().w();
      return;
    }
    bhcm.a().f("none");
    bhcm.a().e("2");
    bhcm.a().c(0);
    Object localObject;
    label101:
    StringBuilder localStringBuilder;
    if (i == 0)
    {
      bhcm.a().b(-1);
      localObject = bhci.a();
      if (this.jdField_a_of_type_Bgya != null) {
        break label201;
      }
      paramView = "";
      ((bhci)localObject).b(paramView);
      localObject = wql.a();
      localStringBuilder = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Bgya != null) {
        break label212;
      }
      paramView = "";
      label134:
      bhcs.a((String)localObject, 1, paramView);
      localObject = wql.a();
      localStringBuilder = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Bgya != null) {
        break label223;
      }
    }
    label201:
    label212:
    label223:
    for (paramView = "";; paramView = Boolean.valueOf(this.jdField_a_of_type_Bgya.d))
    {
      bhcs.a((String)localObject, 1, paramView);
      return;
      bhcm.a().b(i);
      break;
      paramView = this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString;
      break label101;
      paramView = this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString;
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */