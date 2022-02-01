import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class atlf
  extends BaseAdapter
  implements View.OnClickListener
{
  private ArrayList<String> Eb;
  private ArrayList<String> Ec;
  private atdt.a a;
  private CheckBox ad;
  private QQAppInterface app;
  private boolean dhX;
  private Activity mActivity;
  private List<FileManagerEntity> mList;
  
  public atlf(QQAppInterface paramQQAppInterface, Activity paramActivity, List<FileManagerEntity> paramList, boolean paramBoolean, CheckBox paramCheckBox, atdt.a parama)
  {
    this.app = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.mList = paramList;
    this.dhX = paramBoolean;
    this.ad = paramCheckBox;
    this.a = parama;
  }
  
  public int getCount()
  {
    int i = 8;
    if (this.mList.size() < 8) {
      i = this.mList.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return this.mList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    float f;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mActivity).inflate(2131558965, paramViewGroup, false);
      paramView = new atlf.a();
      paramView.b = ((AsyncImageView)localView.findViewById(2131368820));
      paramView.aj = ((ImageView)localView.findViewById(2131368836));
      paramView.Sn = ((TextView)localView.findViewById(2131381973));
      paramView.e = ((NumberCheckBox)localView.findViewById(2131373185));
      paramView.ny = ((RelativeLayout)localView.findViewById(2131373184));
      paramView.cF = ((ImageView)localView.findViewById(2131381579));
      localObject = this.mActivity.getResources().getDisplayMetrics();
      f = ((DisplayMetrics)localObject).density;
      i = ((DisplayMetrics)localObject).widthPixels;
      if (this.dhX)
      {
        i = (int)Math.floor(i - f * 115.0F) / 4;
        paramView.b.setAsyncClipSize(i, i);
        localView.setLayoutParams(new AbsListView.LayoutParams(i, i));
        localView.setTag(paramView);
      }
    }
    for (;;)
    {
      paramView.cF.setVisibility(8);
      athu.c(paramView.b, (FileManagerEntity)this.mList.get(paramInt));
      if ((audx.fM(((FileManagerEntity)this.mList.get(paramInt)).fileName) == 2) && (aqhq.fileExistsAndNotEmpty(athu.j((FileManagerEntity)this.mList.get(paramInt))))) {
        paramView.cF.setVisibility(0);
      }
      this.Eb = new ArrayList();
      this.Ec = new ArrayList();
      i = 0;
      while (i < this.mList.size())
      {
        localObject = (FileManagerEntity)this.mList.get(i);
        this.app.a().v((FileManagerEntity)localObject);
        this.Ec.add(String.valueOf(((FileManagerEntity)localObject).nSessionId));
        if (i < 8) {
          this.Eb.add(String.valueOf(((FileManagerEntity)localObject).nSessionId));
        }
        i += 1;
      }
      i = (int)Math.floor(i - f * 73.0F) / 4;
      break;
      localObject = (atlf.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    if (paramInt < 7)
    {
      paramView.aj.setVisibility(4);
      paramView.Sn.setVisibility(4);
      paramView.b.setOnClickListener(this);
      paramView.b.setTag(this.mList.get(paramInt));
      if (!this.dhX) {
        break label712;
      }
      paramView.ny.setVisibility(0);
      paramView.e.setChecked(atiz.b((atiu)this.mList.get(paramInt)));
      paramView.entity = ((FileManagerEntity)this.mList.get(paramInt));
      paramView.ny.setTag(paramView);
      paramView.ny.setOnClickListener(this);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (paramInt != 7) {
        break;
      }
      if (this.mList.size() == 8)
      {
        paramView.aj.setVisibility(4);
        paramView.Sn.setVisibility(4);
        paramView.b.setOnClickListener(this);
        paramView.b.setTag(this.mList.get(paramInt));
        break;
      }
      if (this.mList.size() <= 8) {
        break;
      }
      paramView.aj.setVisibility(0);
      paramView.Sn.setVisibility(0);
      paramView.Sn.setText("+" + (this.mList.size() - 8));
      paramView.Sn.setOnClickListener(this);
      break;
      label712:
      paramView.ny.setVisibility(4);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = (FileManagerEntity)paramView.getTag();
        if (localObject != null)
        {
          athu.a(this.app, this.mActivity, (atiu)localObject, this.Eb);
          continue;
          localObject = new Intent(this.mActivity, CloudPhotoListActivity.class);
          ((Intent)localObject).putStringArrayListExtra("photo_entity_list_intent", this.Ec);
          if (this.dhX)
          {
            ((Intent)localObject).putExtra("key_file_browser_mode", 2);
            this.mActivity.startActivityForResult((Intent)localObject, 8);
          }
          else
          {
            this.mActivity.startActivity((Intent)localObject);
          }
        }
      }
      localObject = (atlf.a)paramView.getTag();
    } while (localObject == null);
    int i;
    if (!atiz.b(((atlf.a)localObject).entity))
    {
      i = 1;
      label170:
      if (i == 0) {
        break label233;
      }
      ((atlf.a)localObject).e.setChecked(atiz.a(((atlf.a)localObject).entity));
    }
    for (;;)
    {
      if (this.ad != null) {
        this.ad.setChecked(atiz.az(this.mList));
      }
      if (this.a == null) {
        break;
      }
      this.a.etm();
      break;
      i = 0;
      break label170;
      label233:
      ((atlf.a)localObject).e.setChecked(false);
      atiz.b(((atlf.a)localObject).entity);
    }
  }
  
  public void onDestroy() {}
  
  public class a
  {
    public TextView Sn;
    public ImageView aj;
    public AsyncImageView b;
    public ImageView cF;
    public NumberCheckBox e;
    public FileManagerEntity entity;
    public RelativeLayout ny;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlf
 * JD-Core Version:    0.7.0.1
 */