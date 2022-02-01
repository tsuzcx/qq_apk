import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.ThemeImageView;

public class amzc
  extends amzk
{
  public ImageView DC;
  public ImageView DD;
  private View Hf;
  private View Hk;
  private View Hl;
  private TextView LF;
  private TextView LG;
  private TroopLabelLayout a;
  private TroopActiveLayout b;
  private TroopLabelLayout jdField_c_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  private FolderTextView jdField_c_of_type_ComTencentMobileqqWidgetFolderTextView;
  private int dEe;
  public Button hg;
  private ImageView jF;
  private TextView tC;
  
  public amzc(ViewGroup paramViewGroup, int paramInt)
  {
    this.dEe = paramInt;
    switch (this.dEe)
    {
    default: 
      this.acL = 2131560035;
    }
    for (;;)
    {
      paramViewGroup.getResources();
      LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
      localLinearLayout.setOrientation(1);
      localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(this.acL, null, false), new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout.setClickable(true);
      localLinearLayout.setFocusable(true);
      this.view = localLinearLayout;
      aDR();
      return;
      this.acL = 2131560600;
      continue;
      this.acL = 2131560002;
      continue;
      this.acL = 2131561498;
      continue;
      this.acL = 2131561499;
    }
  }
  
  public TextView X()
  {
    return this.tC;
  }
  
  public TextView Y()
  {
    return this.hg;
  }
  
  public TextView Z()
  {
    return this.LF;
  }
  
  public TroopLabelLayout a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  }
  
  protected void aDR()
  {
    super.aDR();
    this.tC = ((TextView)this.view.findViewById(2131368698));
    this.jF = ((ImageView)this.view.findViewById(2131365490));
    switch (this.dEe)
    {
    }
    for (;;)
    {
      this.Hk = this.view.findViewById(2131365404);
      if (this.Hk != null) {
        this.Hk.setTag("ActiveEntitySearchResultPresenter_add_troop");
      }
      this.Hl = this.view.findViewById(2131373609);
      if (this.Hl != null)
      {
        this.Hl.setTag("ActiveEntitySearchResultPresenter_pay_troop");
        if ((this.Hl instanceof ThemeImageView)) {
          ((ThemeImageView)this.Hl).setMaskShape(auvj.euM);
        }
      }
      this.b = ((TroopActiveLayout)this.view.findViewById(2131362042));
      if (this.b != null) {
        this.b.setTag("ActiveEntitySearchResultPresenter_hot_troop");
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)this.view.findViewById(2131367363));
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetFolderTextView != null) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFolderTextView.setTag("ActiveEntitySearchResultPresenter_expand_desc");
      }
      return;
      this.hg = ((Button)this.view.findViewById(2131377201));
      this.LF = ((TextView)this.view.findViewById(2131377211));
      this.a = ((TroopLabelLayout)this.view.findViewById(2131380324));
      this.LG = ((TextView)this.view.findViewById(2131371194));
      this.Hf = this.view.findViewById(2131380904);
      continue;
      this.DC = ((ImageView)this.view.findViewById(2131380238));
      this.DD = ((ImageView)this.view.findViewById(2131380198));
      this.jdField_c_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.view.findViewById(2131380324));
      if (this.titleView != null)
      {
        TextView localTextView = this.titleView;
        int j = ankt.SCREEN_WIDTH - ankt.dip2px(187.0F);
        int i = j;
        if (j <= 0) {
          i = ankt.dip2px(220.0F);
        }
        localTextView.setMaxWidth(i);
      }
    }
  }
  
  public TextView aa()
  {
    return this.LG;
  }
  
  public TroopLabelLayout b()
  {
    return this.a;
  }
  
  public View cu()
  {
    return this.Hf;
  }
  
  public View g(String paramString)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString)) {
      return this.Hk;
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return this.Hl;
    }
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString)) {
      return this.b;
    }
    if ("ActiveEntitySearchResultPresenter_expand_desc".equals(paramString)) {
      return this.jdField_c_of_type_ComTencentMobileqqWidgetFolderTextView;
    }
    return super.g(paramString);
  }
  
  public ImageView g()
  {
    return this.jF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzc
 * JD-Core Version:    0.7.0.1
 */