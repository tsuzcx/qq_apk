package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ReadInJoyDisLikeDialogView
  extends FrameLayout
  implements View.OnClickListener
{
  protected Boolean H = Boolean.valueOf(true);
  protected a a;
  protected b a;
  private Button[] a;
  protected Button bU;
  private View contentView;
  protected int[] du = { 2131381267, 2131381268, 2131381269, 2131381270, 2131381271, 2131381272, 2131381273, 2131381274 };
  protected int[] dv = { 2131381262, 2131381263, 2131381264, 2131381265 };
  private RelativeLayout fl;
  protected RelativeLayout fm;
  private ImageView imageView;
  private View[] l;
  protected ArrayList<DislikeInfo> lE;
  protected ArrayList<DislikeInfo> lF;
  private TextView tips;
  
  public ReadInJoyDisLikeDialogView(Context paramContext)
  {
    super(paramContext);
    cj(paramContext);
  }
  
  private void aWk()
  {
    int i = this.lE.size();
    if (i >= this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      i = this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length;
      j = 0;
      label25:
      if (j >= i) {
        break label117;
      }
      if (!TextUtils.isEmpty(((DislikeInfo)this.lE.get(j)).agQ)) {
        break label81;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
      break label25;
      break;
      label81:
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setText(((DislikeInfo)this.lE.get(j)).agQ);
    }
    label117:
    int j = i;
    if (j < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if ((j == i) && (i % 2 == 1)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(4);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
    }
    i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].getVisibility() == 8) {
        this.l[(i / 2)].setVisibility(8);
      }
      for (;;)
      {
        i += 2;
        break;
        this.l[(i / 2)].setVisibility(0);
      }
    }
  }
  
  protected void cj(Context paramContext)
  {
    int j = 0;
    this.contentView = LayoutInflater.from(paramContext).inflate(2131560268, this);
    this.fl = ((RelativeLayout)this.contentView.findViewById(2131381260));
    this.fl.setBackgroundColor(getResources().getColor(2131167654));
    this.imageView = ((ImageView)this.contentView.findViewById(2131381278));
    this.imageView.setVisibility(8);
    this.tips = ((TextView)this.contentView.findViewById(2131381275));
    this.tips.setText(paramContext.getString(2131701912));
    this.bU = ((Button)this.contentView.findViewById(2131381257));
    this.bU.setOnClickListener(this);
    this.bU.setEnabled(false);
    this.fm = ((RelativeLayout)this.contentView.findViewById(2131381259));
    this.fm.setOnClickListener(this);
    this.fm.setBackgroundColor(Color.parseColor("#FFF6F7FA"));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[this.du.length];
    int i = 0;
    while (i < this.du.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i] = ((Button)this.contentView.findViewById(this.du[i]));
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setOnClickListener(this);
      i += 1;
    }
    this.l = new View[this.dv.length];
    i = j;
    while (i < this.dv.length)
    {
      this.l[i] = this.contentView.findViewById(this.dv[i]);
      i += 1;
    }
  }
  
  public void clear()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$b = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$a = null;
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    case 2131381258: 
    default: 
      i = 0;
      if (i < this.du.length) {
        if (paramView.getId() != this.du[i]) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        if (!this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected()) {
          break label187;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
        this.lF.remove(this.lE.get(i));
        label99:
        if (this.lF.size() != 0) {
          break label267;
        }
        this.bU.setEnabled(false);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$b.a(paramView, this.lF, null)))
        {
          clear();
          continue;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$a != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$a.aNT();
          }
          clear();
          continue;
          i += 1;
          break;
          label187:
          if (!this.H.booleanValue())
          {
            Button[] arrayOfButton = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
            int k = arrayOfButton.length;
            int j = 0;
            while (j < k)
            {
              arrayOfButton[j].setSelected(false);
              j += 1;
            }
            this.lF.clear();
          }
          this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(true);
          this.lF.add(this.lE.get(i));
          break label99;
          label267:
          this.bU.setEnabled(true);
        }
      }
      i = -1;
    }
  }
  
  public void setOnComplainListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$a = parama;
  }
  
  public void setOnUninterestConfirmListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDisLikeDialogView$b = paramb;
  }
  
  public void setUninterestData(ArrayList<DislikeInfo> paramArrayList)
  {
    if (this.lF == null)
    {
      this.lF = new ArrayList();
      if (this.lE != null) {
        break label60;
      }
      this.lE = new ArrayList();
    }
    for (;;)
    {
      this.lE.addAll(paramArrayList);
      aWk();
      return;
      this.lF.clear();
      break;
      label60:
      this.lE.clear();
    }
  }
  
  public static abstract interface a
  {
    public abstract void aNT();
  }
  
  public static abstract interface b
  {
    public abstract boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView
 * JD-Core Version:    0.7.0.1
 */