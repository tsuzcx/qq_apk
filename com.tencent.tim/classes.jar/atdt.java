import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamwork.TeamWorkAuthorizeSettingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atdt
  extends PinnedDividerListView.a
  implements atjr.a
{
  public List<Object> GW = new ArrayList();
  private atdt.a jdField_a_of_type_Atdt$a;
  aths.a jdField_a_of_type_Aths$a = new atdw(this);
  protected atjw a;
  private atkt jdField_a_of_type_Atkt = new atkt(0L);
  protected auhk.e a;
  protected auhk.i a;
  protected auhk.j a;
  protected QQAppInterface app;
  protected atjx b;
  protected boolean cLe;
  protected boolean cLf;
  protected View.OnClickListener clickListener = new atdu(this);
  private boolean dhp;
  private boolean dhq;
  protected int entrance;
  protected int epp;
  private Handler handler = new atdv(this);
  protected int mActionType;
  protected Context mContext;
  public int mSelectedPosition = -1;
  protected int mode = 0;
  protected View.OnClickListener onClickListener;
  protected View.OnLongClickListener onLongClickListener;
  
  public atdt(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, augx paramaugx)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.entrance = paramInt;
    this.jdField_a_of_type_Atjw = new atjw(paramQQAppInterface, paramContext);
    this.b = new atjx(paramQQAppInterface, paramContext, paramaugx);
    this.jdField_a_of_type_Auhk$e = this.b.a(2);
    this.jdField_a_of_type_Auhk$i = ((auhk.i)this.b.a(4));
    this.jdField_a_of_type_Auhk$j = ((auhk.j)this.b.a(3));
    aths.a().a(this.jdField_a_of_type_Aths$a);
    if ((paramContext instanceof Activity))
    {
      paramQQAppInterface = ((Activity)paramContext).getIntent();
      if (paramQQAppInterface != null)
      {
        this.mActionType = paramQQAppInterface.getIntExtra("key_bottom_bar_right_action", 0);
        if (QLog.isColorLevel()) {
          QLog.d("CloudFileAdapter", 2, "mActionType = " + this.mActionType + ", context name = " + ((Activity)paramContext).getLocalClassName());
        }
      }
    }
  }
  
  public atdt(QQAppInterface paramQQAppInterface, Context paramContext, augx paramaugx)
  {
    this(paramQQAppInterface, paramContext, 6, paramaugx);
  }
  
  public void Vq(boolean paramBoolean)
  {
    this.cLe = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void Vr(boolean paramBoolean)
  {
    Object localObject = this.GW.iterator();
    atiu localatiu;
    while (((Iterator)localObject).hasNext())
    {
      localatiu = (atiu)((Iterator)localObject).next();
      if ((localatiu.getCloudFileType() == 2) || (localatiu.getCloudFileType() == 0) || (localatiu.getCloudFileType() == 1))
      {
        if (paramBoolean) {
          break label113;
        }
        atiz.a(localatiu);
        label67:
        if (atiz.mW(1)) {
          break label118;
        }
      }
    }
    if (this.jdField_a_of_type_Atdt$a != null)
    {
      this.jdField_a_of_type_Atdt$a.etm();
      localObject = this.jdField_a_of_type_Atdt$a;
      if (!paramBoolean) {
        break label120;
      }
    }
    label113:
    label118:
    label120:
    for (paramBoolean = false;; paramBoolean = true)
    {
      ((atdt.a)localObject).Vu(paramBoolean);
      notifyDataSetChanged();
      return;
      atiz.b(localatiu);
      break label67;
      break;
    }
  }
  
  public void Vs(boolean paramBoolean)
  {
    this.dhp = paramBoolean;
  }
  
  public void Vt(boolean paramBoolean)
  {
    this.dhq = paramBoolean;
  }
  
  public void a(int paramInt, atiu paramatiu)
  {
    if (paramatiu.getCloudFileType() == 0) {
      switch (paramInt)
      {
      }
    }
    label856:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        return;
                                      } while (this.jdField_a_of_type_Auhk$e == null);
                                      this.jdField_a_of_type_Auhk$e.al(new Object[] { paramatiu });
                                      return;
                                      atiz.clearSelected();
                                      atiz.a(paramatiu);
                                    } while (this.jdField_a_of_type_Auhk$e == null);
                                    localObject = new ArrayList();
                                    ((List)localObject).add(paramatiu);
                                    this.jdField_a_of_type_Auhk$e.nT((List)localObject);
                                    return;
                                    atiz.clearSelected();
                                    atiz.a(paramatiu);
                                  } while (this.jdField_a_of_type_Auhk$e == null);
                                  this.jdField_a_of_type_Auhk$e.bG(paramatiu);
                                  return;
                                  atiz.clearSelected();
                                  atiz.a(paramatiu);
                                } while (this.jdField_a_of_type_Auhk$e == null);
                                localObject = new ArrayList();
                                ((List)localObject).add(paramatiu);
                                this.jdField_a_of_type_Auhk$e.nS((List)localObject);
                                return;
                              } while (this.jdField_a_of_type_Auhk$e == null);
                              this.jdField_a_of_type_Auhk$e.bH(paramatiu);
                              return;
                              if (paramatiu.getCloudFileType() != 1) {
                                break;
                              }
                              switch (paramInt)
                              {
                              case 2131364768: 
                              case 2131364769: 
                              case 2131364771: 
                              default: 
                                return;
                              }
                            } while (this.jdField_a_of_type_Auhk$e == null);
                            this.jdField_a_of_type_Auhk$e.al(new Object[] { paramatiu });
                            return;
                            atiz.clearSelected();
                            atiz.a(paramatiu);
                          } while (this.jdField_a_of_type_Auhk$e == null);
                          localObject = new ArrayList();
                          ((List)localObject).add(paramatiu);
                          this.jdField_a_of_type_Auhk$e.nT((List)localObject);
                          return;
                        } while (this.jdField_a_of_type_Auhk$e == null);
                        this.jdField_a_of_type_Auhk$e.bH(paramatiu);
                        return;
                        if (paramatiu.getCloudFileType() != 2) {
                          break label856;
                        }
                        if (!(paramatiu instanceof PadInfo)) {
                          break;
                        }
                        switch (paramInt)
                        {
                        case 2131364770: 
                        case 2131364765: 
                        case 2131364766: 
                        case 2131364768: 
                        case 2131364769: 
                        default: 
                          return;
                        case 2131364764: 
                          atiz.clearSelected();
                          atiz.a(paramatiu);
                        }
                      } while (this.jdField_a_of_type_Auhk$j == null);
                      this.jdField_a_of_type_Auhk$j.bG(paramatiu);
                      return;
                    } while (this.jdField_a_of_type_Auhk$j == null);
                    this.jdField_a_of_type_Auhk$j.al(new Object[] { paramatiu });
                    return;
                  } while (this.jdField_a_of_type_Auhk$j == null);
                  this.jdField_a_of_type_Auhk$j.b((PadInfo)paramatiu);
                  return;
                } while (this.jdField_a_of_type_Auhk$j == null);
                this.jdField_a_of_type_Auhk$j.bH(paramatiu);
                return;
                paramatiu = (PadInfo)paramatiu;
                localObject = new Intent(this.mContext, TeamWorkAuthorizeSettingActivity.class);
                ((Intent)localObject).putExtra("team_work_name", paramatiu.title);
                ((Intent)localObject).putExtra("team_work_pad_url", paramatiu.pad_url);
                ((Intent)localObject).putExtra("team_work_pad_list_type", paramatiu.type_list);
                athu.h(this.mContext, (Intent)localObject, 1002);
                return;
                switch (paramInt)
                {
                case 2131364768: 
                case 2131364765: 
                case 2131364766: 
                case 2131364769: 
                default: 
                  return;
                case 2131364764: 
                  atiz.clearSelected();
                  atiz.a(paramatiu);
                }
              } while (this.jdField_a_of_type_Auhk$e == null);
              this.jdField_a_of_type_Auhk$e.bG(paramatiu);
              return;
            } while (this.jdField_a_of_type_Auhk$e == null);
            this.jdField_a_of_type_Auhk$e.al(new Object[] { paramatiu });
            return;
            atiz.clearSelected();
            atiz.a(paramatiu);
          } while (this.jdField_a_of_type_Auhk$e == null);
          localObject = new ArrayList();
          ((List)localObject).add(paramatiu);
          this.jdField_a_of_type_Auhk$e.nT((List)localObject);
          return;
        } while ((this.jdField_a_of_type_Auhk$j == null) || (!(paramatiu instanceof FileManagerEntity)));
        paramatiu = athu.a((FileManagerEntity)paramatiu);
        this.jdField_a_of_type_Auhk$j.b(paramatiu);
        return;
      } while (this.jdField_a_of_type_Auhk$e == null);
      this.jdField_a_of_type_Auhk$e.bH(paramatiu);
      return;
      paramatiu = athu.a((FileManagerEntity)paramatiu);
      Object localObject = new Intent(this.mContext, TeamWorkAuthorizeSettingActivity.class);
      ((Intent)localObject).putExtra("team_work_name", paramatiu.title);
      ((Intent)localObject).putExtra("team_work_pad_url", paramatiu.pad_url);
      ((Intent)localObject).putExtra("team_work_pad_list_type", paramatiu.type_list);
      athu.h(this.mContext, (Intent)localObject, 1002);
      return;
    } while (paramatiu.getCloudFileType() != 9);
    paramatiu = (atkw)paramatiu;
    switch (paramInt)
    {
    default: 
      return;
    case 2131364767: 
      this.jdField_a_of_type_Auhk$i.al(new Object[] { paramatiu });
      return;
    case 2131364768: 
      this.jdField_a_of_type_Auhk$i.c(paramatiu);
      return;
    }
    this.jdField_a_of_type_Auhk$i.d(paramatiu);
  }
  
  public void a(atdt.a parama)
  {
    this.jdField_a_of_type_Atdt$a = parama;
  }
  
  protected void a(atiu paramatiu)
  {
    if (this.jdField_a_of_type_Atdt$a != null) {
      return;
    }
    if ((paramatiu.getCloudFileType() == 2) || (paramatiu.getCloudFileType() == 0)) {
      atiz.a(paramatiu);
    }
    if (this.jdField_a_of_type_Atdt$a != null) {
      this.jdField_a_of_type_Atdt$a.etm();
    }
    notifyDataSetChanged();
  }
  
  protected void a(atjv paramatjv)
  {
    if ((paramatjv instanceof atjr))
    {
      ((atjr)paramatjv).a(this);
      ((atjr)paramatjv).setMode(this.mode);
    }
  }
  
  public int ag()
  {
    if (this.dhp) {
      return 0;
    }
    return 2131558960;
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.GW.size() != 0)
    {
      atiu localatiu = (atiu)this.GW.get(paramInt);
      if (((localatiu instanceof atkr)) || ((this.GW.size() > paramInt + 1) && ((this.GW.get(paramInt + 1) instanceof atkr))))
      {
        atjy localatjy = (atjy)this.jdField_a_of_type_Atjw.a(4, this, this.entrance);
        a(localatjy);
        localatjy.a(new atjy.a(), paramView);
        localatjy.a(paramInt, localatiu, paramView, (ViewGroup)paramView.getParent(), this.cLe, false, this.onClickListener, this.onLongClickListener, this.jdField_a_of_type_Atdt$a, false, -1);
      }
      paramView.setVisibility(8);
    }
  }
  
  public int getCount()
  {
    return this.GW.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.GW.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    atiu localatiu = (atiu)this.GW.get(paramInt);
    return this.jdField_a_of_type_Atjw.a(localatiu);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    atiu localatiu = (atiu)this.GW.get(paramInt);
    atjv localatjv2 = this.jdField_a_of_type_Atjw.a(localatiu, this, this.entrance);
    atjv localatjv1 = localatjv2;
    if (localatjv2 == null)
    {
      localatjv1 = this.jdField_a_of_type_Atjw.a(localatiu.getCloudFileType(), this, this.entrance);
      a(localatjv1);
    }
    if ((localatjv1 instanceof atjz))
    {
      if (!this.dhq) {
        break label151;
      }
      ((atjz)localatjv1).VB(true);
    }
    for (;;)
    {
      boolean bool = atiz.b(localatiu);
      paramView = localatjv1.a(paramInt, localatiu, paramView, paramViewGroup, this.cLe, bool, this.clickListener, this.onLongClickListener, this.jdField_a_of_type_Atdt$a, this.cLf, this.mSelectedPosition);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      label151:
      ((atjz)localatjv1).VB(false);
    }
  }
  
  public int getViewTypeCount()
  {
    return 13;
  }
  
  public void mx(List<? extends Object> paramList)
  {
    this.GW.clear();
    int i;
    label45:
    atiu localatiu;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.GW.addAll(paramList);
      paramList = this.GW.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label143;
      }
      localatiu = (atiu)paramList.next();
      if (localatiu != null) {
        break label103;
      }
      paramList.remove();
      QLog.w("CloudFileAdapter", 1, "filelist contains null ");
    }
    label143:
    for (;;)
    {
      break label45;
      this.GW.add(this.jdField_a_of_type_Atkt);
      break;
      label103:
      if ((localatiu != null) && ((localatiu.getCloudFileType() == 2) || (localatiu.getCloudFileType() == 0) || (localatiu.getCloudFileType() == 1)))
      {
        i += 1;
        continue;
        this.epp = i;
        notifyDataSetChanged();
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atjw != null) {
      this.jdField_a_of_type_Atjw.onDestroy();
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
    aths.a().b(this.jdField_a_of_type_Aths$a);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.jdField_a_of_type_Atkt.setMode(paramInt);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.onLongClickListener = paramOnLongClickListener;
  }
  
  public boolean t(int paramInt)
  {
    if (this.GW.size() != 0) {
      return ((atiu)this.GW.get(paramInt) instanceof atkr);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void Vu(boolean paramBoolean);
    
    public abstract void etm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdt
 * JD-Core Version:    0.7.0.1
 */