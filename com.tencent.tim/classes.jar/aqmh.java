import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.a;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.c;
import com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqmh
  extends ShareActionSheetBuilder
{
  protected Bitmap mBitmap;
  
  public aqmh(Context paramContext)
  {
    super(paramContext, false);
  }
  
  public View L()
  {
    View localView = View.inflate(this.V, 2131563081, null);
    this.a.B((RelativeLayout)localView.findViewById(2131362258));
    this.mTitleTv = ((TextView)localView.findViewById(2131362010));
    Object localObject2;
    Object localObject1;
    if (this.zO)
    {
      this.mTitleTv.setVisibility(0);
      if (this.ac != null) {
        this.mTitleTv.setText(this.ac);
      }
      this.c = ((ElasticHorScrView)localView.findViewById(2131377768));
      this.d = ((ElasticHorScrView)localView.findViewById(2131377769));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label390;
      }
      localObject1 = localObject2[0];
      label122:
      if (!((List)localObject1).isEmpty()) {
        break label1202;
      }
    }
    label147:
    label1185:
    label1191:
    label1194:
    label1197:
    label1202:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label1197;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.V.getResources().getDimensionPixelSize(2131299551));
        Object localObject4 = new StaticLayout(a((TextPaint)localObject3, this.dAd, q((List)localObject1), 5), (TextPaint)localObject3, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        StaticLayout localStaticLayout = new StaticLayout(a((TextPaint)localObject3, this.dAd, q((List)localObject2), 5), (TextPaint)localObject3, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.V.getResources().getDimensionPixelOffset(2131296956);
        int i;
        if (j != 0)
        {
          this.n = ((GridView)localView.findViewById(2131368140));
          if (Build.VERSION.SDK_INT >= 9) {
            this.c.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label350:
          if (((Iterator)localObject4).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
              break label1194;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label350;
          hideTitle();
          break;
          localObject1 = new ArrayList(0);
          break label122;
          localObject2 = new ArrayList(0);
          break label147;
          int n = this.dAc + getIconWidth() + this.dAc;
          this.n.setColumnWidth(n);
          this.n.setNumColumns(i);
          localObject4 = this.n.getLayoutParams();
          this.n.setPadding(this.dAg, this.n.getPaddingTop(), this.dAg, this.n.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.dAg + this.dAg);
          this.bgd = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.OC + this.dAe + ((StaticLayout)localObject3).getHeight() + m);
          this.n.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.n.setAdapter(new ShareActionSheetBuilder.a(this.V, (List)localObject1));
          this.n.setSelector(new ColorDrawable(0));
          this.n.setOnItemClickListener(this.j);
          if (k != 0)
          {
            this.o = ((GridView)localView.findViewById(2131368141));
            if (Build.VERSION.SDK_INT >= 9) {
              this.d.setOverScrollMode(2);
            }
            this.o.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
                break label1191;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.dAc + getIconWidth() + this.dAc;
            this.o.setColumnWidth(n);
            this.o.setNumColumns(i);
            localObject1 = this.o.getLayoutParams();
            this.o.setPadding(this.dAg, this.o.getPaddingTop(), this.dAg, this.o.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.dAg + this.dAg);
            this.bgc = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.OC + this.dAe + ((StaticLayout)localObject3).getHeight() + m);
            this.o.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.o.setNumColumns(i);
            this.o.setAdapter(new ShareActionSheetBuilder.a(this.V, (List)localObject2));
            this.o.setSelector(new ColorDrawable(0));
            this.o.setOnItemClickListener(this.j);
            localObject1 = (TextView)localView.findViewById(2131362002);
            ((TextView)localObject1).setText(2131721058);
            ((TextView)localObject1).setOnClickListener(new aqmi(this));
            if (j == 0) {
              this.c.setVisibility(8);
            }
            if (k == 0) {
              this.d.setVisibility(8);
            }
            localView.post(new ShareWithPictureActionSheetBuilder.2(this));
            j = aqnm.dip2px(90.0F);
            i = j;
            if (this.n != null) {
              i = j + this.n.getLayoutParams().height;
            }
            if (this.o != null) {
              i += this.o.getLayoutParams().height;
            }
            for (;;)
            {
              k = this.V.getResources().getDisplayMetrics().widthPixels;
              j = this.V.getResources().getDisplayMetrics().heightPixels;
              localObject1 = (RelativeLayout)localView.findViewById(2131378196);
              localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = (j - i);
              ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              if (this.mBitmap != null)
              {
                m = aqnm.dip2px(20.0F);
                j = j - i - aqnm.dip2px(30.0F) * 2;
                i = this.mBitmap.getWidth() * j / this.mBitmap.getHeight();
                if (i <= k - m * 2) {
                  break label1185;
                }
                i = k - m * 2;
                j = this.mBitmap.getHeight() * i / this.mBitmap.getWidth();
              }
              for (;;)
              {
                localObject1 = (ImageView)localView.findViewById(2131378195);
                localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).height = j;
                ((RelativeLayout.LayoutParams)localObject2).width = i;
                ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((ImageView)localObject1).setImageBitmap(this.mBitmap);
                return localView;
              }
            }
          }
        }
      }
    }
  }
  
  public void ai(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    this.bpu = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmh
 * JD-Core Version:    0.7.0.1
 */