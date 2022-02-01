import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.richstatus.NoScrollGridView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class atkl
  extends atjv
  implements View.OnClickListener
{
  private List<FileManagerEntity> Hl;
  private atdt.a jdField_a_of_type_Atdt$a;
  private atlf jdField_a_of_type_Atlf;
  
  public atkl(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = this.context.getResources().getDisplayMetrics();
    float f2 = ((DisplayMetrics)localObject).density;
    float f3 = ((DisplayMetrics)localObject).widthPixels;
    float f1;
    int j;
    int i;
    if (paramBoolean)
    {
      f1 = 122.0F * f2;
      j = (int)Math.floor(f3 - f1);
      localObject = "";
      i = j;
      if (this.Hl.size() > 1)
      {
        if ((paramInt1 != 0) || (paramInt2 <= 0)) {
          break label147;
        }
        localObject = "等" + paramInt2 + "个视频";
        i = (int)Math.floor(j - f2 * 100.0F);
      }
    }
    for (;;)
    {
      paramTextView1.setMaxWidth(i);
      paramTextView2.setText((CharSequence)localObject);
      return;
      f1 = 80.0F * f2;
      break;
      label147:
      if ((paramInt2 == 0) && (paramInt1 > 0))
      {
        localObject = "等" + paramInt1 + "张图片";
        i = (int)Math.floor(j - f2 * 100.0F);
      }
      else if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localObject = "等" + paramInt1 + "张图片," + paramInt2 + "个视频";
        i = (int)Math.floor(j - f2 * 200.0F);
      }
      else
      {
        localObject = "";
        i = j;
      }
    }
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, atdt.a parama, boolean paramBoolean3, int paramInt2)
  {
    label222:
    float f2;
    label271:
    FileManagerEntity localFileManagerEntity;
    float f1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558962, null);
      paramViewGroup = new atkl.a();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView = ((NoScrollGridView)paramView.findViewById(2131368146));
      paramViewGroup.i = ((AsyncImageView)paramView.findViewById(2131364798));
      paramViewGroup.aeU = ((TextView)paramView.findViewById(2131364795));
      paramViewGroup.aeV = ((TextView)paramView.findViewById(2131364802));
      paramViewGroup.aeW = ((TextView)paramView.findViewById(2131364801));
      paramViewGroup.ab = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.xk = ((ImageView)paramView.findViewById(2131362978));
      paramViewGroup.bt = ((RelativeLayout)paramView.findViewById(2131364799));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setNumColumns(4);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setStretchMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setHorizontalSpacing(2);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setVerticalSpacing(2);
      paramViewGroup.dhX = paramBoolean1;
      paramView.setTag(paramViewGroup);
      if (!paramBoolean1) {
        break label366;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.ab.setChecked(paramBoolean2);
      paramViewGroup.xk.setVisibility(0);
      paramInt2 = 0;
      paramInt1 = 0;
      this.Hl = ((FileManagerEntity)paramatiu).combinePhotoList;
      if ((this.Hl == null) || (this.Hl.size() <= 0)) {
        break label613;
      }
      paramOnLongClickListener = this.Hl.iterator();
      f2 = 0.0F;
      if (!paramOnLongClickListener.hasNext()) {
        break label416;
      }
      localFileManagerEntity = (FileManagerEntity)paramOnLongClickListener.next();
      f1 = f2;
      if (localFileManagerEntity == null) {
        break label758;
      }
      f1 = f2;
      if (localFileManagerEntity.cloudFile == null) {
        break label758;
      }
      f2 += (float)localFileManagerEntity.fileSize;
      if (localFileManagerEntity.cloudFile.fileType != 2) {
        break label389;
      }
      paramInt2 += 1;
      f1 = f2;
    }
    label366:
    label758:
    for (;;)
    {
      f2 = f1;
      break label271;
      paramViewGroup = (atkl.a)paramView.getTag();
      break;
      paramViewGroup.ab.setVisibility(8);
      paramViewGroup.xk.setVisibility(8);
      break label222;
      f1 = f2;
      if (localFileManagerEntity.cloudFile.fileType == 4)
      {
        paramInt1 += 1;
        f1 = f2;
        continue;
        int i = audx.fM(((FileManagerEntity)this.Hl.get(0)).fileName);
        paramOnLongClickListener = paramViewGroup.i;
        if (i == 2) {}
        for (i = 2130839393;; i = 2130839386)
        {
          paramOnLongClickListener.setImageResource(i);
          paramOnLongClickListener = athu.a(this.app, this.context, ((FileManagerEntity)this.Hl.get(0)).cloudFile.aioRecentFileExt, false, 0);
          a(paramViewGroup.aeU, paramViewGroup.aeV, paramInt2, paramInt1, paramBoolean1);
          paramViewGroup.aeU.setText(((FileManagerEntity)this.Hl.get(0)).fileName);
          paramViewGroup.aeW.setText(auqb.cq(((FileManagerEntity)this.Hl.get(this.Hl.size() - 1)).getSortTime()) + " " + paramOnLongClickListener + " " + athu.c(f2));
          paramViewGroup.jdField_a_of_type_Atiu = paramatiu;
          paramViewGroup.isSelected = paramBoolean2;
          paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131369420));
          paramViewGroup.je = ((RelativeLayout)paramView.findViewById(2131377943));
          paramViewGroup.checkBox.setChecked(atiz.az(this.Hl));
          paramViewGroup.je.setTag(paramViewGroup);
          paramViewGroup.je.setOnClickListener(this);
          this.jdField_a_of_type_Atdt$a = parama;
          this.jdField_a_of_type_Atlf = new atlf(this.app, (Activity)this.context, this.Hl, paramBoolean1, paramViewGroup.checkBox, parama);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setAdapter(this.jdField_a_of_type_Atlf);
          paramView.setOnClickListener(paramOnClickListener);
          return paramView;
        }
      }
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Atlf.onDestroy();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    switch (paramView.getId())
    {
    }
    Object localObject;
    List localList;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = (atkl.a)paramView.getTag();
      } while (localObject == null);
      localList = ((FileManagerEntity)((atkl.a)localObject).jdField_a_of_type_Atiu).combinePhotoList;
    } while ((localList == null) || (localList.size() <= 0));
    int i;
    if (!atiz.az(localList))
    {
      i = 1;
      label84:
      if (i == 0) {
        break label169;
      }
      atiz.nK(localList);
      bool1 = atiz.ay(localList);
      label99:
      ((BaseAdapter)((atkl.a)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.getAdapter()).notifyDataSetChanged();
      if (((atkl.a)localObject).checkBox != null)
      {
        localObject = ((atkl.a)localObject).checkBox;
        if ((i == 0) || (!bool1)) {
          break label179;
        }
      }
    }
    label169:
    label179:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((CheckBox)localObject).setChecked(bool1);
      if (this.jdField_a_of_type_Atdt$a == null) {
        break;
      }
      this.jdField_a_of_type_Atdt$a.etm();
      break;
      i = 0;
      break label84;
      atiz.nK(localList);
      bool1 = true;
      break label99;
    }
  }
  
  public class a
    extends atjv.a
  {
    public NoScrollGridView a;
    CheckBox ab;
    TextView aeU;
    TextView aeV;
    TextView aeW;
    RelativeLayout bt;
    public boolean dhX;
    AsyncImageView i;
    RelativeLayout je;
    ImageView xk;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkl
 * JD-Core Version:    0.7.0.1
 */