import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayff
  implements ayqy.a
{
  public ayff.a a;
  private ayjk jdField_a_of_type_Ayjk;
  private ayqy jdField_a_of_type_Ayqy;
  private DoodleView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private ElasticImageView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  private SparseArray<ayjk> ek = new SparseArray();
  private RelativeLayout fT;
  private Context mContext;
  
  public ayff(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)paramRelativeLayout.findViewById(2131363024));
    this.fT = ((RelativeLayout)paramRelativeLayout.findViewById(2131377609));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)paramRelativeLayout.findViewById(2131369885));
    this.jdField_a_of_type_Ayqy = new ayqy(this.mContext);
    this.jdField_a_of_type_Ayqy.a(this);
    eRf();
    eRg();
  }
  
  private void eRf()
  {
    ayki localayki = new ayki.a().a(new aykc()).a(720).b(1280).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(localayki);
  }
  
  private void eRg()
  {
    int i = 0;
    while (i < aykc.js.length)
    {
      ayjk localayjk = (ayjk)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(aykc.js[i]);
      localayjk.a(new ayff.c());
      localayjk.a(new ayff.b());
      this.ek.put(i, localayjk);
      i += 1;
    }
    this.jdField_a_of_type_Ayjk = ((ayjk)this.ek.get(0));
  }
  
  public static String sO(@NonNull String paramString)
  {
    if (paramString.getBytes().length <= 24)
    {
      ram.d("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk no need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
      return paramString;
    }
    ram.d("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk need to cut out. remark = %s. byte length = %d.", paramString, Integer.valueOf(paramString.getBytes().length));
    int k = "...".getBytes().length;
    Object localObject2 = paramString.substring(0, 8);
    int j = ((String)localObject2).getBytes().length;
    int i = 8;
    String str;
    for (Object localObject1 = localObject2; i <= paramString.length(); localObject1 = str)
    {
      if (j + k == 24)
      {
        ram.d("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", localObject1 + "...", Integer.valueOf((localObject1 + "...").getBytes().length));
        return localObject1 + "...";
      }
      if (j + k > 24)
      {
        ram.d("Q.qqstory.publish.edit.EditVideoAtDoodleController", "processReamrk after cuting out. remark = %s. byte length = %d.", (String)localObject2 + "...", Integer.valueOf(((String)localObject2 + "...").getBytes().length));
        return (String)localObject2 + "...";
      }
      i += 1;
      str = paramString.substring(0, i);
      j = str.getBytes().length;
      localObject2 = localObject1;
    }
    return localObject1;
  }
  
  private void xs(int paramInt)
  {
    if (this.jdField_a_of_type_Ayff$a != null) {
      this.jdField_a_of_type_Ayff$a.onStateChanged(paramInt);
    }
  }
  
  public void a(ayff.a parama)
  {
    this.jdField_a_of_type_Ayff$a = parama;
  }
  
  public Bitmap aY()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.U();
  }
  
  public void afe(int paramInt)
  {
    ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer. index:" + paramInt);
    if ((this.ek == null) || (paramInt < 0) || (paramInt >= this.ek.size()))
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Invalid index.");
      return;
    }
    if (this.ek.get(paramInt) == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "changeAtLayer error. Layer is null.");
      return;
    }
    this.jdField_a_of_type_Ayjk = ((ayjk)this.ek.get(paramInt));
    paramInt = 0;
    while (paramInt < this.ek.size())
    {
      ayjk localayjk = (ayjk)this.ek.get(paramInt);
      if (localayjk != null) {
        localayjk.setVisibility(false);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Ayjk.setVisibility(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  @NonNull
  public List<String> au(int paramInt)
  {
    if ((this.ek == null) || (paramInt < 0) || (paramInt >= this.ek.size())) {
      return Collections.EMPTY_LIST;
    }
    ayjk localayjk = (ayjk)this.ek.get(paramInt);
    if (localayjk == null) {
      return Collections.EMPTY_LIST;
    }
    return localayjk.hX();
  }
  
  public void bJ(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    ram.b("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel uin = %s remark = %s name = %s.", paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_Ayjk.uo(paramString1)) {
      return;
    }
    int i = wja.dp2px(20.0F, this.mContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_Ayqy.b(paramString1, i, i);
    if (localDrawable == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "createStoryFaceDrawable failed, uin=%s, width=%s, height=%s.", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(i) });
      return;
    }
    paramString2 = sO(paramString2);
    ayjk.c localc = ayon.a(this.mContext, localDrawable, paramString2, 0);
    if (localc != null)
    {
      if ((this.jdField_a_of_type_Ayjk.getWidth() == 0) || (this.jdField_a_of_type_Ayjk.getHeight() == 0))
      {
        ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "Add the at label while the layer's size is 0. Force to set the layer's size to the screen's size.");
        i = azbx.SCREEN_WIDTH;
        int j = azbx.aC(this.mContext);
        this.jdField_a_of_type_Ayjk.setSize(i, j);
      }
      this.jdField_a_of_type_Ayjk.a(paramString1, localDrawable, paramString2, paramString3, localc, null);
      return;
    }
    ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "addAtLabel init params failed..");
  }
  
  public void eRh()
  {
    if (this.jdField_a_of_type_Ayjk != null) {
      this.jdField_a_of_type_Ayjk.notifyChange();
    }
  }
  
  public String ha(int paramInt)
  {
    if ((this.ek == null) || (paramInt < 0) || (paramInt >= this.ek.size()))
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. Invalid index.");
      return null;
    }
    ayjk localayjk = (ayjk)this.ek.get(paramInt);
    if (localayjk == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtJsonData error. layer is null.");
      return null;
    }
    return localayjk.Ir();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.isEmpty();
  }
  
  public int lW(int paramInt)
  {
    if ((this.ek == null) || (paramInt < 0) || (paramInt >= this.ek.size()))
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. Invalid index.");
      return 0;
    }
    ayjk localayjk = (ayjk)this.ek.get(paramInt);
    if (localayjk == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAtDoodleController", "getAtCount error. layer is null.");
      return 0;
    }
    return localayjk.tp();
  }
  
  public void onDestory()
  {
    ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "onDestory");
    this.jdField_a_of_type_Ayqy.destroy();
  }
  
  public boolean un(String paramString)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.un(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onStateChanged(int paramInt);
  }
  
  public class b
    implements ayjk.b
  {
    public b() {}
    
    public void a(ayjk.a parama)
    {
      if (parama.direction == 0)
      {
        f1 = parama.centerP.x;
        f2 = parama.translateXValue;
        f3 = -parama.width;
        if (f1 + f2 + f3 >= parama.width / 2.0F)
        {
          ayff.a(ayff.this).y(1, f3 + parama.translateXValue);
          return;
        }
        ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
        return;
      }
      float f1 = parama.centerP.x;
      float f2 = parama.translateXValue;
      float f3 = parama.width;
      if (f1 + f2 + f3 <= ayff.a(ayff.this).getWidth() - parama.width / 2.0F)
      {
        ayff.a(ayff.this).y(0, f3 + parama.translateXValue);
        return;
      }
      ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
    }
    
    public void xj(int paramInt)
    {
      QQToast.a(ayff.a(ayff.this), "最多可以圈10个好友哦", 0).show();
    }
  }
  
  public class c
    implements aykd.a<ayjk>
  {
    private final int PADDING = wja.dp2px(40.0F, ayff.a(ayff.this).getResources());
    private Rect aE;
    private final int bqf = 5;
    private boolean dyO;
    private AtomicBoolean eQ = new AtomicBoolean(false);
    private float mLastX;
    private float mLastY;
    private final float vW = 1.5F;
    
    public c() {}
    
    public boolean a(ayjk paramayjk, MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 2: 
        label97:
        do
        {
          return false;
          this.mLastX = f1;
          this.mLastY = f2;
          this.eQ.set(false);
          return false;
          float f3 = Math.abs(f2 - this.mLastY);
          float f4 = Math.abs(f1 - this.mLastX);
          int i;
          if (f3 > 5.0F)
          {
            i = 1;
            if (f4 <= 5.0F) {
              break label324;
            }
          }
          for (int j = 1; (j | i) != 0; j = 0)
          {
            this.mLastX = f1;
            this.mLastY = f2;
            if (!this.eQ.getAndSet(true))
            {
              ayff.a(ayff.this).setVisibility(0);
              this.aE = new Rect();
              ayff.a(ayff.this).getGlobalVisibleRect(this.aE);
              paramayjk = this.aE;
              paramayjk.left -= this.PADDING;
              paramayjk = this.aE;
              paramayjk.top -= this.PADDING;
              paramayjk = this.aE;
              paramayjk.right += this.PADDING;
              paramayjk = this.aE;
              paramayjk.bottom += this.PADDING;
              ayff.a(ayff.this, 9);
            }
            if (!this.aE.contains((int)f1, (int)f2)) {
              break label330;
            }
            ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the at label enter rubbish area.");
            this.dyO = true;
            ayff.a(ayff.this).ag(1.5F);
            ayff.a(ayff.this).getDrawable().setColorFilter(Color.parseColor("#F31919"), PorterDuff.Mode.MULTIPLY);
            return false;
            i = 0;
            break label97;
          }
        } while (!this.dyO);
        label324:
        label330:
        ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the face leave rubbish area.");
        this.dyO = false;
        ayff.a(ayff.this).ag(1.0F);
        ayff.a(ayff.this).getDrawable().clearColorFilter();
        return false;
      }
      if (this.eQ.get())
      {
        if ((this.aE != null) && (this.aE.contains((int)f1, (int)f2)))
        {
          ram.i("Q.qqstory.publish.edit.EditVideoAtDoodleController", "remove at label.");
          ayff.a(ayff.this).ag(1.0F);
          ayff.a(ayff.this).getDrawable().clearColorFilter();
          ayff.a(ayff.this).eRY();
        }
        ayff.a(ayff.this, 0);
      }
      ayff.a(ayff.this).setVisibility(4);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayff
 * JD-Core Version:    0.7.0.1
 */