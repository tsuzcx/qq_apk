import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.List;

public class atkh
  extends atjr
{
  public atkh(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    label189:
    atkw localatkw;
    label278:
    label322:
    long l;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558987, null);
      paramViewGroup = new atkh.a(null);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364710));
      paramViewGroup.h = ((AsyncImageView)paramView.findViewById(2131364720));
      paramViewGroup.aeR = ((TextView)paramView.findViewById(2131364718));
      paramViewGroup.aeS = ((TextView)paramView.findViewById(2131364717));
      paramViewGroup.fileSize = ((TextView)paramView.findViewById(2131364716));
      paramViewGroup.ab = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.aeT = ((TextView)paramView.findViewById(2131364709));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(36.0F, this.context.getResources()), wja.dp2px(36.0F, this.context.getResources()));
      paramView.setTag(paramViewGroup);
      if (!paramBoolean1) {
        break label496;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.ab.setChecked(paramBoolean2);
      localatkw = (atkw)paramatiu;
      paramViewGroup.jdField_a_of_type_Atiu = paramatiu;
      paramViewGroup.isSelected = paramBoolean2;
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(paramOnClickListener);
      paramViewGroup.h.setVisibility(8);
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      if (!paramBoolean1) {
        break label509;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.ab.setChecked(paramBoolean2);
      if (localatkw.relatedType != 7) {
        break label610;
      }
      paramOnClickListener = (PadInfo)localatkw.fQ;
      if (paramOnClickListener != null)
      {
        if (paramOnClickListener.type != 1) {
          break label522;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130851565);
        paramViewGroup.aeR.setText(paramOnClickListener.title);
        l = paramOnClickListener.currentUserBrowseTime;
        paramatiu = String.format(this.context.getResources().getString(2131720947), new Object[] { this.context.getResources().getString(2131720945) });
        if ((!this.app.getCurrentAccountUin().equals(String.valueOf(paramOnClickListener.lastEditorUin))) || (paramOnClickListener.lastEditTime < paramOnClickListener.currentUserBrowseTime)) {
          break label745;
        }
        paramatiu = String.format(this.context.getResources().getString(2131720944), new Object[] { this.context.getResources().getString(2131720945) });
        l = paramOnClickListener.lastEditTime;
      }
    }
    label522:
    label610:
    label745:
    for (;;)
    {
      if (paramatiu != null)
      {
        paramViewGroup.fileSize.setText(paramatiu);
        paramatiu = auqb.bG(l);
        paramViewGroup.aeS.setText(paramatiu);
      }
      label496:
      label509:
      do
      {
        return paramView;
        paramViewGroup = (atkh.a)paramView.getTag();
        break;
        paramViewGroup.ab.setVisibility(8);
        break label189;
        paramViewGroup.ab.setVisibility(8);
        break label278;
        if (paramOnClickListener.type == 2)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130851566);
          break label322;
        }
        if (paramOnClickListener.type == 3)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130851567);
          break label322;
        }
        if (paramOnClickListener.type != 4) {
          break label322;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130851577);
        break label322;
        paramViewGroup.fileSize.setText("");
        paramViewGroup.aeS.setText("");
        return paramView;
        paramViewGroup.aeR.setText(localatkw.fileName);
        athu.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localatkw);
        paramatiu = auqb.bG(localatkw.getSortTime());
        paramViewGroup.aeS.setText(paramatiu);
        paramViewGroup.fileSize.setText(audx.a(this.context, localatkw.a) + " " + athu.c((float)localatkw.fileSize));
        paramViewGroup.h.setVisibility(8);
      } while ((audx.fM(localatkw.fileName) != 2) || (!aqhq.fileExistsAndNotEmpty(localatkw.uZ())));
      paramViewGroup.h.setVisibility(0);
      return paramView;
    }
  }
  
  public List<atiw> a(atiu paramatiu)
  {
    paramatiu = (atkw)paramatiu;
    ArrayList localArrayList = new ArrayList();
    if (paramatiu.relatedType == 7) {
      localArrayList.add(h);
    }
    for (;;)
    {
      localArrayList.add(b);
      return localArrayList;
      localArrayList.add(d);
    }
  }
  
  public void destroy() {}
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    localArrayList.add(h);
    localArrayList.add(b);
    return localArrayList;
  }
  
  class a
    extends atjv.a
  {
    AsyncImageView a;
    CheckBox ab;
    TextView aeR;
    TextView aeS;
    TextView aeT;
    TextView fileSize;
    AsyncImageView h;
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkh
 * JD-Core Version:    0.7.0.1
 */