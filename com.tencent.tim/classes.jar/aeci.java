import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aeci
  extends RecyclerView.Adapter<aeci.d>
{
  private aeci.c jdField_a_of_type_Aeci$c;
  private aecv jdField_a_of_type_Aecv;
  private boolean bST;
  private List<ColorNote> yG;
  
  public void Hi(boolean paramBoolean)
  {
    this.bST = paramBoolean;
  }
  
  public aeci.d a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aeci.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559013, paramViewGroup, false));
  }
  
  public void a(aeci.c paramc)
  {
    this.jdField_a_of_type_Aeci$c = paramc;
  }
  
  public void a(aeci.d paramd, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.yG.get(paramInt);
    aeay.a(localColorNote).a(paramd, paramInt, this.bST);
    int j;
    int i;
    if (aebs.j(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = ykf.a(localColorNote);
      j = aqcx.dip2px(paramd.title.getContext(), 200.0F);
      i = 0;
      if (aebs.i(localColorNote)) {
        i = aqcx.dip2px(paramd.title.getContext(), 27.0F);
      }
      if (localUpComingMsgModel.uniseq.size() <= 1) {
        break label140;
      }
      paramd.title.setMaxWidth(j);
      aofy.a(paramd.title, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramd, paramInt, getItemId(paramInt));
      return;
      label140:
      aofy.a(paramd.title, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
    }
  }
  
  public int getItemCount()
  {
    if (this.yG == null) {
      return 0;
    }
    return this.yG.size();
  }
  
  void jF(List<ColorNote> paramList)
  {
    this.yG = paramList;
  }
  
  public void setHideListener(aecv paramaecv)
  {
    this.jdField_a_of_type_Aecv = paramaecv;
  }
  
  static class a
    implements View.OnClickListener
  {
    aeci.d jdField_a_of_type_Aeci$d;
    aeci jdField_a_of_type_Aeci;
    
    a(aeci paramaeci, aeci.d paramd)
    {
      this.jdField_a_of_type_Aeci = paramaeci;
      this.jdField_a_of_type_Aeci$d = paramd;
    }
    
    public void onClick(View paramView)
    {
      int i = this.jdField_a_of_type_Aeci$d.getAdapterPosition();
      ColorNote localColorNote = (ColorNote)aeci.a(this.jdField_a_of_type_Aeci).get(i);
      aeba.w(localColorNote.mServiceType, localColorNote.mSubType);
      aeci.a(this.jdField_a_of_type_Aeci).remove(i);
      this.jdField_a_of_type_Aeci.notifyDataSetChanged();
      switch (localColorNote.getServiceType())
      {
      default: 
        if (aebs.h(localColorNote))
        {
          if ((aebr.a().agp()) && (aebd.agn())) {
            aeci.a(this.jdField_a_of_type_Aeci).gr(paramView);
          }
          anot.a(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", aeax.gU(aebs.gV(localColorNote.getServiceType())), 0, "", "", "", "");
        }
        break;
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Aeci.getItemCount() == 0) && (aeci.a(this.jdField_a_of_type_Aeci) != null)) {
          aeci.a(this.jdField_a_of_type_Aeci).cVJ();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        QQPlayerService.eG(paramView.getContext());
        break;
        anot.a(null, "dc00898", "", "", "0X800A747", "0X800A747", aeax.gT(localColorNote.getServiceType()), 0, "", "", "", "");
      }
    }
  }
  
  static class b
    implements View.OnClickListener
  {
    aeci.d jdField_a_of_type_Aeci$d;
    aeci jdField_a_of_type_Aeci;
    
    b(aeci paramaeci, aeci.d paramd)
    {
      this.jdField_a_of_type_Aeci = paramaeci;
      this.jdField_a_of_type_Aeci$d = paramd;
    }
    
    public void onClick(View paramView)
    {
      aeay.a(paramView.getContext(), (ColorNote)aeci.a(this.jdField_a_of_type_Aeci).get(this.jdField_a_of_type_Aeci$d.getAdapterPosition()));
      if (aeci.a(this.jdField_a_of_type_Aeci) != null) {
        aeci.a(this.jdField_a_of_type_Aeci).cVJ();
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  public static abstract interface c
  {
    public abstract void gr(View paramView);
  }
  
  public static class d
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public View Bs;
    aeci.a jdField_a_of_type_Aeci$a;
    aeci jdField_a_of_type_Aeci;
    public View container;
    Drawable drawable;
    public Button fP;
    public TextView title;
    public TextView xW;
    public ImageView yq;
    
    public d(aeci paramaeci, View paramView)
    {
      super();
      this.jdField_a_of_type_Aeci = paramaeci;
      Resources localResources = paramView.getContext().getResources();
      paramView.setOnClickListener(this);
      View localView1 = paramView.findViewById(2131372499);
      aqcl.Q(localView1, false);
      localView1.setOnClickListener(this);
      View localView2 = paramView.findViewById(2131372502);
      aqcl.Q(localView2, false);
      localView2.setOnClickListener(this);
      if (aeci.a(paramaeci))
      {
        i = 8;
        localView1.setVisibility(i);
        if (!aeci.a(paramaeci)) {
          break label334;
        }
      }
      label334:
      for (int i = j;; i = 8)
      {
        localView2.setVisibility(i);
        this.container = paramView.findViewById(2131372488);
        this.container.setContentDescription(localResources.getString(2131691734));
        this.Bs = paramView.findViewById(2131372484);
        this.yq = ((ImageView)paramView.findViewById(2131372489));
        this.title = ((TextView)paramView.findViewById(2131372505));
        this.title.setCompoundDrawablePadding(wja.dp2px(3.0F, localResources));
        this.title.setFocusable(true);
        this.title.setFocusableInTouchMode(true);
        aqcl.Q(this.title, true);
        this.xW = ((TextView)paramView.findViewById(2131372503));
        this.xW.setFocusable(true);
        this.xW.setFocusableInTouchMode(true);
        aqcl.Q(this.xW, true);
        this.fP = ((Button)paramView.findViewById(2131372491));
        this.jdField_a_of_type_Aeci$a = new aeci.a(paramaeci, this);
        this.fP.setOnClickListener(this.jdField_a_of_type_Aeci$a);
        this.container.setOnClickListener(new aeci.b(paramaeci, this));
        this.drawable = new MusicDanceDrawable();
        ((aebi)this.drawable).f(paramView.getContext(), wja.dp2px(15.0F, localResources), wja.dp2px(9.5F, localResources));
        return;
        i = 0;
        break;
      }
    }
    
    public ColorNote a(int paramInt)
    {
      return (ColorNote)aeci.a(this.jdField_a_of_type_Aeci).get(paramInt);
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aeci.a(this.jdField_a_of_type_Aeci) != null)
        {
          aeci.a(this.jdField_a_of_type_Aeci).cVJ();
          anot.a(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeci
 * JD-Core Version:    0.7.0.1
 */