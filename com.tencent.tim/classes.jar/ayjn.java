import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(11)
public class ayjn
  extends aykd
{
  public static final String TAG = ayjn.class.getSimpleName();
  public ayjn.b a;
  public ayjn.c a;
  public ayoo a;
  public boolean aHA;
  public Paint aU;
  public Paint aV;
  public Paint aW;
  public Paint aX;
  public Paint di;
  public Drawable di;
  public Paint dj;
  public Paint dk;
  public Map<String, List<String>> gg = new HashMap();
  public int mStartY;
  public TextPaint mTextPaint;
  public List<ayjn.b> oJ = new CopyOnWriteArrayList();
  public List<ayjn.b> oK = new ArrayList();
  public Map<String, List<String>> qT = new HashMap();
  
  public ayjn(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    init();
  }
  
  private void M(MotionEvent paramMotionEvent)
  {
    if (z(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.oJ.remove(this.jdField_a_of_type_Ayjn$b);
      this.oJ.add(this.jdField_a_of_type_Ayjn$b);
    }
  }
  
  private void N(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Ayjn$b != null) {
      this.jdField_a_of_type_Ayjn$b.dzF = false;
    }
    this.jdField_a_of_type_Ayjn$b = null;
    this.jdField_a_of_type_Ayoo.reset();
    super.notifyChange();
    super.tJ(false);
    eSo();
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)paramFloat;
    if (paramInt3 == 0) {
      return i;
    }
    float f = paramFloat;
    if (paramFloat - paramInt1 / 2 < paramInt2) {
      f = paramInt1 / 2 + paramInt2;
    }
    paramFloat = f;
    if (paramInt1 / 2 + f > paramInt3) {
      paramFloat = paramInt3 - paramInt1 / 2;
    }
    return (int)paramFloat;
  }
  
  private void a(ayjn.b paramb, Canvas paramCanvas)
  {
    if (paramb == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Ayoo.a(paramb));
    paramb.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(ayjn.b paramb, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramb.category);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(paramb.category, localObject);
    }
    ((List)localObject).add(paramb.name);
  }
  
  private void b(ayjn.b paramb)
  {
    boolean bool1 = this.jdField_a_of_type_Ayoo.a(paramb, StoryGuideLineView.bqQ, true);
    boolean bool2 = this.jdField_a_of_type_Ayoo.a(paramb, StoryGuideLineView.bqR, false);
    boolean bool3 = this.jdField_a_of_type_Ayoo.b(paramb, StoryGuideLineView.bqT, false);
    if (this.jdField_a_of_type_Ayjn$c != null) {
      this.jdField_a_of_type_Ayjn$c.b(bool1, bool2, false, bool3, paramb.aIq);
    }
    if (paramb != null)
    {
      if (paramb.aIp) {
        this.b.a(paramb.aIq, paramb.nI, paramb.translateXValue, paramb.translateYValue, paramb.centerP, paramb.aHC, 2);
      }
    }
    else {
      return;
    }
    this.b.a(paramb.aIq, paramb.nI, paramb.translateXValue, paramb.translateYValue, paramb.centerP, paramb.aHC, 1);
  }
  
  private void b(ayjn.b paramb, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramb.category);
    if (localList != null)
    {
      localList.remove(paramb.name);
      if (localList.isEmpty()) {
        paramMap.remove(paramb.category);
      }
    }
  }
  
  public static boolean cA(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  private void cancelAnimator()
  {
    if (this.jdField_a_of_type_Ayjn$b != null) {
      this.jdField_a_of_type_Ayjn$b.cancelAnimator();
    }
  }
  
  private void click()
  {
    if ((this.jdField_a_of_type_Ayjn$c != null) && (this.jdField_a_of_type_Ayjn$b != null) && (this.jdField_a_of_type_Ayjn$c.a(this.jdField_a_of_type_Ayjn$b))) {
      this.oJ.remove(this.jdField_a_of_type_Ayjn$b);
    }
  }
  
  private void eSb()
  {
    this.b.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public static Bitmap i(Drawable paramDrawable)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void init()
  {
    this.aU = new Paint();
    this.jdField_di_of_type_AndroidGraphicsDrawableDrawable = this.context.getResources().getDrawable(2130847618);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setTypeface(Typeface.DEFAULT);
    this.aV = new Paint();
    this.aV.setAntiAlias(true);
    this.aV.setStyle(Paint.Style.STROKE);
    this.aV.setColor(-65536);
    this.aV.setStrokeWidth(2.0F);
    this.aW = new Paint();
    this.aW.setAntiAlias(true);
    this.aW.setStyle(Paint.Style.STROKE);
    this.aW.setColor(-16711936);
    this.aW.setStrokeWidth(2.0F);
    this.aI.setStrokeWidth(2.0F);
    this.aX = new Paint();
    this.aX.setStrokeWidth(1.0F);
    this.aX.setColor(-1);
    this.aX.setStyle(Paint.Style.STROKE);
    this.aX.setPathEffect(new DashPathEffect(new float[] { 8.0F, 6.0F }, 0.0F));
    this.jdField_a_of_type_Ayoo = new ayoo();
    this.jdField_a_of_type_Ayoo.tP(true);
    this.jdField_a_of_type_Ayoo.setMaxScale(18.0F);
    this.jdField_a_of_type_Ayoo.setMinScale(0.2F);
    this.jdField_di_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_di_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_di_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_di_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_di_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.dk = new Paint();
    this.dk.setAntiAlias(true);
    this.dk.setColor(-1);
    this.dk.setStyle(Paint.Style.FILL);
    this.dj = new Paint();
    this.dj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.dj.setStyle(Paint.Style.FILL);
  }
  
  private boolean z(float paramFloat1, float paramFloat2)
  {
    int i = this.oJ.size() - 1;
    if (i >= 0)
    {
      ayjn.b localb = (ayjn.b)this.oJ.get(i);
      if ((localb.mSegmentKeeper != null) && (localb.aQT()) && (!localb.mSegmentKeeper.isCurrentIn())) {}
      while (!this.jdField_a_of_type_Ayoo.a(localb, paramFloat1, paramFloat2, false))
      {
        i -= 1;
        break;
      }
      this.jdField_a_of_type_Ayjn$b = localb;
      return true;
    }
    return false;
  }
  
  public boolean E(JSONObject paramJSONObject)
  {
    if ((this.oJ == null) || (this.oJ.isEmpty())) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject1 = this.oJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (ayjn.b)((Iterator)localObject1).next();
        Object localObject2 = new PasterParcelData((ayjn.b)localObject3);
        JSONObject localJSONObject = ((PasterParcelData)localObject2).convertToJSON();
        localJSONObject.put("trackingEnable", ((ayjn.b)localObject3).dzE);
        if ((localObject2 != null) && (((ayjn.b)localObject3).isAnchor) && (((ayjn.b)localObject3).dzH))
        {
          localJSONObject.put("isAnchor", ((ayjn.b)localObject3).isAnchor);
          localJSONObject.put("isInKiteMode", ((ayjn.b)localObject3).dzH);
          localJSONObject.put("trackerTransX", ((ayjn.b)localObject3).FH);
          localJSONObject.put("trackerTransY", ((ayjn.b)localObject3).FI);
          localJSONObject.put("trackerScreenX", ((ayjn.b)localObject3).FJ);
          localJSONObject.put("trackerScreenY", ((ayjn.b)localObject3).FK);
          localJSONObject.put("touchDownInNail", ((ayjn.b)localObject3).dzF);
          localJSONObject.put("trackerStartScale", ((ayjn.b)localObject3).FM);
          localJSONObject.put("trackingState", ((ayjn.b)localObject3).eKr);
          localObject2 = new JSONArray();
          localObject3 = ((ayjn.b)localObject3).qU.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            ((JSONArray)localObject2).put(localEntry.getKey());
            ((JSONArray)localObject2).put(((TrackerStickerParam.MotionInfo)localEntry.getValue()).convertToJSON());
          }
          localJSONObject.put("motionInfo", localObject2);
        }
        localJSONArray.put(localJSONObject);
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("topLevelWeight", this.eKq);
      ((JSONObject)localObject1).put("isEditPic", this.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La());
      ((JSONObject)localObject1).put("faceItems", localJSONArray);
      paramJSONObject.put(Is(), localObject1);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public Bundle G()
  {
    Bundle localBundle = super.G();
    ArrayList localArrayList = new ArrayList(this.oJ.size());
    int i = 0;
    while (i < this.oJ.size())
    {
      localArrayList.add(new PasterParcelData((ayjn.b)this.oJ.get(i)));
      i += 1;
    }
    localBundle.putParcelableArrayList("StickerParcelDataList", localArrayList);
    return localBundle;
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.mStartY);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Ayoo.a(paramMotionEvent, false);
      if (this.jdField_a_of_type_Ayjn$b == null) {
        break;
      }
      b(this.jdField_a_of_type_Ayjn$b);
      return true;
      this.mStartY = i;
      this.aHA = false;
      M(paramMotionEvent);
      if (this.jdField_a_of_type_Ayjn$b != null) {
        this.jdField_a_of_type_Ayoo.l(this.jdField_a_of_type_Ayjn$b);
      }
      eSc();
      if (this.jdField_a_of_type_Ayjn$b != null)
      {
        this.jdField_a_of_type_Ayjn$b.startAnimator();
        continue;
        cancelAnimator();
        continue;
        if (j > 5)
        {
          this.aHA = true;
          cancelAnimator();
          continue;
          cancelAnimator();
          if (!this.aHA) {
            click();
          }
          N(paramMotionEvent);
        }
      }
    }
    eSb();
    return true;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.oJ.size() - 1;
    if (i >= 0)
    {
      ayjn.b localb = (ayjn.b)this.oJ.get(i);
      if ((localb.aQT()) && (!localb.mSegmentKeeper.isCurrentIn())) {}
      while (!this.jdField_a_of_type_Ayoo.a(localb, f1, f2, false))
      {
        i -= 1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public String Is()
  {
    return "FaceLayer";
  }
  
  protected boolean Ln()
  {
    return tp() >= 40;
  }
  
  public ayoo.a a(ayoo.a parama, String paramString1, String paramString2, Drawable paramDrawable, ayjn.d paramd, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      ram.e(TAG, "Face drawable is null.");
      return null;
    }
    if (paramd == null)
    {
      ram.e(TAG, "ItemParams is null.");
      return null;
    }
    ayjn.d locald = ayjn.d.a(parama, paramd);
    ayjn.b localb;
    if ((parama instanceof ayjn.b))
    {
      localb = (ayjn.b)parama;
      if (localb.dzB)
      {
        this.oK.remove(localb);
        b(localb, this.qT);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramd.text)) {
        break label321;
      }
      ram.d(TAG, "Create Normal FaceItem.");
      paramString2 = new ayjn.b(paramDrawable, locald, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.Zt(paramBoolean);
      if ((paramDrawable instanceof ayob)) {
        paramString2.Zu(aynb.oC(((ayob)paramDrawable).getType()));
      }
      if (!TextUtils.isEmpty(paramString5)) {
        paramInt1 = -1;
      }
    }
    try
    {
      paramInt2 = Integer.valueOf(paramString5.substring(paramString5.indexOf(":") + 1, paramString5.indexOf(","))).intValue();
      paramInt1 = paramInt2;
    }
    catch (Exception paramString1)
    {
      label199:
      break label199;
    }
    paramString2.Zu(aynb.oC(paramInt1));
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.e = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
      paramString2.poiUpdateTime = System.currentTimeMillis();
      paramString1 = paramString2;
    }
    label254:
    paramString1.dzB = paramBoolean;
    if (!TextUtils.isEmpty(paramString5)) {
      paramString1.data = paramString5;
    }
    paramString1.a(parama);
    if (paramString1.dzB) {
      this.oK.add(paramString1);
    }
    for (;;)
    {
      b(paramString1, this.qT);
      return paramString1;
      b(localb, this.gg);
      break;
      label321:
      ram.d(TAG, "Create FaceAndTextItem with text:" + locald.text);
      paramString1 = new ayjn.a(paramDrawable, locald, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      break label254;
      b(paramString1, this.gg);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext())
    {
      ayjn.b localb = (ayjn.b)localIterator.next();
      if ((localb.eGY == 0) && ((paramBoolean) || ((!localb.aQL()) && (!localb.aQT()))))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_Ayoo.a(localb));
        localb.a(paramCanvas, false);
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
  
  public void a(ayjn.b paramb)
  {
    if ((this.oJ != null) && (!this.oJ.isEmpty()) && (this.oJ.remove(paramb)))
    {
      if (!paramb.dzB) {
        break label78;
      }
      DoodleLayout.sx("delete_poi");
      ras.so("0X80076D2");
      ras.sp("0X80075E7");
      this.oK.remove(paramb);
    }
    for (;;)
    {
      b(paramb, this.qT);
      return;
      label78:
      DoodleLayout.sx("delete_oneface");
      ras.so("0X80076CB");
      ras.sp("0X80075E0");
      b(paramb, this.gg);
    }
  }
  
  public void a(ayjn.b paramb, TroopBarPOI paramTroopBarPOI)
  {
    if (paramb != null)
    {
      paramb.c(paramTroopBarPOI);
      paramb.drawable.setCallback(this.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a);
      notifyChange();
    }
  }
  
  public void a(ayjn.c paramc)
  {
    this.jdField_a_of_type_Ayjn$c = paramc;
  }
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      ThreadManager.post(new FaceLayer.1(this, paramArrayList, paramJSONArray, paramBoolean), 8, null, false);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, ayjn.d paramd, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      ram.e(TAG, "Face drawable is null.");
      return false;
    }
    if (paramd == null)
    {
      ram.e(TAG, "ItemParams is null.");
      return false;
    }
    if (Ln())
    {
      ram.e(TAG, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Ayjn$c != null) {
        this.jdField_a_of_type_Ayjn$c.xj(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.b);
    }
    ram.a(TAG, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramd);
    ayjn.d locald = ayjn.d.a(paramd);
    int k = (int)(locald.width * locald.scale);
    int j = (int)(locald.height * locald.scale);
    int i = j;
    if (this.drawRect.height() < j)
    {
      f1 = locald.scale;
      locald.scale = (this.drawRect.height() / j * f1);
      i = this.drawRect.height();
    }
    float f1 = locald.centerP.x;
    float f2 = locald.centerP.y;
    locald.centerP.x = a(f1, k, this.drawRect.left, this.drawRect.right);
    locald.centerP.y = a(f2, i, this.drawRect.top, this.drawRect.bottom);
    ram.d(TAG, "addFace after drawRect:" + this.drawRect);
    ram.a(TAG, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramd);
    if (TextUtils.isEmpty(locald.text))
    {
      ram.d(TAG, "Create Normal FaceItem.");
      paramString2 = new ayjn.b(paramDrawable, locald, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.Zt(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof ayob))
      {
        paramString2.Zu(aynb.oC(((ayob)paramDrawable).getType()));
        paramString1 = paramString2;
      }
      paramString1.mSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      c(paramString1);
      if (paramInt2 == 0) {
        SegmentKeeper.adjustTime(-1L * System.currentTimeMillis());
      }
      this.oJ.add(paramString1);
      super.notifyChange();
      if (!paramString1.dzB) {
        break label521;
      }
      this.oK.add(paramString1);
    }
    for (;;)
    {
      a(paramString1, this.qT);
      return true;
      ram.d(TAG, "Create FaceAndTextItem with text:" + locald.text);
      paramString1 = new ayjn.a(paramDrawable, locald, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((ayjn.a)paramString1).btN();
      break;
      label521:
      a(paramString1, this.gg);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, ayjn.d paramd, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      ram.e(TAG, "Face drawable is null.");
      return false;
    }
    if (paramd == null)
    {
      ram.e(TAG, "ItemParams is null.");
      return false;
    }
    if (Ln())
    {
      ram.e(TAG, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Ayjn$c != null) {
        this.jdField_a_of_type_Ayjn$c.xj(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.b);
    }
    ram.a(TAG, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramd);
    ayjn.d locald = ayjn.d.a(paramd);
    int k = (int)(locald.width * locald.scale);
    int j = (int)(locald.height * locald.scale);
    int i = j;
    if (this.drawRect.height() < j)
    {
      f1 = locald.scale;
      locald.scale = (this.drawRect.height() / j * f1);
      i = this.drawRect.height();
    }
    float f1 = locald.centerP.x;
    float f2 = locald.centerP.y;
    locald.centerP.x = a(f1, k, this.drawRect.left, this.drawRect.right);
    locald.centerP.y = a(f2, i, this.drawRect.top, this.drawRect.bottom);
    ram.d(TAG, "addFace after drawRect:" + this.drawRect);
    ram.a(TAG, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramd);
    i = -1;
    if (TextUtils.isEmpty(locald.text))
    {
      ram.d(TAG, "Create Normal FaceItem.");
      paramString2 = new ayjn.b(paramDrawable, locald, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.data = paramString5;
      paramString2.Zt(paramBoolean);
      if (!TextUtils.isEmpty(paramString4))
      {
        if ((paramString2 instanceof ayjn.a)) {
          paramString2.c(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
      }
      else
      {
        if (!(paramDrawable instanceof ayob)) {
          break label545;
        }
        paramInt1 = ((ayob)paramDrawable).getType();
        paramString2.Zu(aynb.oC(paramInt1));
        paramString1 = paramString2;
        label437:
        if (((paramDrawable instanceof aynz)) || (12 == paramInt1)) {
          paramString1.nI = 90.0F;
        }
        paramString1.eGZ = paramInt2;
        this.oJ.add(paramString1);
        super.notifyChange();
        if (!paramString1.dzB) {
          break label673;
        }
        this.oK.add(paramString1);
      }
    }
    for (;;)
    {
      for (;;)
      {
        a(paramString1, this.qT);
        return true;
        paramString2.e = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
        paramString2.poiUpdateTime = System.currentTimeMillis();
        break;
        label545:
        paramString1 = paramString2;
        paramInt1 = i;
        if (TextUtils.isEmpty(paramString5)) {
          break label437;
        }
        try
        {
          paramInt1 = Integer.valueOf(paramString5.substring(paramString5.indexOf(":") + 1, paramString5.indexOf(","))).intValue();
          paramString2.Zu(aynb.oC(paramInt1));
          paramString1 = paramString2;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramInt1 = -1;
          }
        }
      }
      ram.d(TAG, "Create FaceAndTextItem with text:" + locald.text);
      paramString1 = new ayjn.a(paramDrawable, locald, paramString1, paramString2, paramString3, paramInt1);
      ((ayjn.a)paramString1).btN();
      paramInt1 = i;
      break label437;
      label673:
      a(paramString1, this.gg);
    }
  }
  
  public Map<String, List<String>> aN()
  {
    return this.qT;
  }
  
  public boolean aN(long paramLong)
  {
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext()) {
      if (((ayjn.b)localIterator.next()).mSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public void afk(int paramInt)
  {
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext())
    {
      ayjn.b localb = (ayjn.b)localIterator.next();
      if (localb.mSegmentKeeper != null) {
        localb.mSegmentKeeper.setMode(paramInt);
      }
    }
  }
  
  protected void an(Canvas paramCanvas)
  {
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext()) {
      a((ayjn.b)localIterator.next(), paramCanvas);
    }
  }
  
  public void ao(Canvas paramCanvas)
  {
    a(paramCanvas, this.scaleValue, false);
  }
  
  public void btM()
  {
    if ((this.oJ != null) && (!this.oJ.isEmpty())) {
      a((ayjn.b)this.oJ.get(this.oJ.size() - 1));
    }
  }
  
  public Rect c(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Ayjn$b != null)
    {
      int i = (int)(this.jdField_a_of_type_Ayjn$b.width * this.jdField_a_of_type_Ayjn$b.scaleValue);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public void c(ayjn.b paramb)
  {
    if ((paramb.drawable == null) || (!(paramb.drawable instanceof BitmapDrawable))) {}
    long l1;
    label95:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)paramb.drawable).getBitmap();
      int k = ((Bitmap)localObject).getWidth();
      int m = ((Bitmap)localObject).getHeight();
      int[] arrayOfInt = new int[k * m];
      ((Bitmap)localObject).getPixels(arrayOfInt, 0, k, 0, 0, k, m);
      localObject = new int[k * 2];
      int i = 0;
      if (i < k)
      {
        j = 0;
        if (j < m)
        {
          if ((arrayOfInt[(j * k + i)] >> 24 & 0xFF) > 0) {
            localObject[(i * 2)] = j;
          }
        }
        else {
          j = m - 1;
        }
        for (;;)
        {
          if (j >= 0)
          {
            if ((arrayOfInt[(j * k + i)] >> 24 & 0xFF) > 0) {
              localObject[(i * 2 + 1)] = j;
            }
          }
          else
          {
            i += 1;
            break;
            j += 1;
            break label95;
          }
          j -= 1;
        }
      }
      int j = (int)paramb.width;
      paramb.um = new int[j * 2];
      float f1 = k / paramb.width;
      float f2 = paramb.height / m;
      i = 0;
      while (i < j)
      {
        k = (int)(i * f1);
        paramb.um[(i * 2)] = ((int)(localObject[(k * 2)] * f2));
        paramb.um[(i * 2 + 1)] = ((int)(localObject[(k * 2 + 1)] * f2));
        if (localObject[(k * 2 + 1)] > 0)
        {
          if (paramb.eMv == -1) {
            paramb.eMv = i;
          }
          paramb.eMw = Math.max(i, paramb.eMw);
        }
        i += 1;
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, new Object[] { "computePixelScope cost: ", Long.valueOf(l2 - l1) });
  }
  
  public void clear()
  {
    this.oJ.clear();
    this.jdField_a_of_type_Ayjn$b = null;
    this.jdField_a_of_type_Ayoo.reset();
    ram.d(TAG, "clear over.");
  }
  
  public void eC(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.eC(paramBundle);
    a(paramBundle.getParcelableArrayList("StickerParcelDataList"), paramBundle.getBoolean("edit_type_photo"), null);
  }
  
  public ArrayList<TrackerStickerParam> eO()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.oJ != null) && (this.oJ.size() > 0))
    {
      Iterator localIterator = this.oJ.iterator();
      while (localIterator.hasNext())
      {
        ayjn.b localb = (ayjn.b)localIterator.next();
        if ((localb.aQL()) || (localb.aQT()))
        {
          TrackerStickerParam localTrackerStickerParam = new TrackerStickerParam(localb.centerP.x, localb.centerP.y, localb.scaleValue, localb.nI, localb.translateXValue, localb.translateYValue, localb.width, localb.height, this.b.mWidth, this.b.mHeight, localb.path, localb.qU);
          localTrackerStickerParam.setSegmentList(localb.mSegmentKeeper.getSegmentList());
          localArrayList.add(localTrackerStickerParam);
        }
      }
    }
    return localArrayList;
  }
  
  public void eSa()
  {
    if ((this.oJ != null) && (!this.oJ.isEmpty()))
    {
      this.oJ.clear();
      this.oK.clear();
      this.gg.clear();
      this.qT.clear();
    }
  }
  
  public void eSc()
  {
    if ((this.jdField_a_of_type_Ayjn$b != null) && (!this.jdField_a_of_type_Ayjn$b.aQK()) && (!this.jdField_a_of_type_Ayjn$b.isTracking())) {
      this.jdField_a_of_type_Ayjn$b.eSc();
    }
  }
  
  public String getTag()
  {
    return TAG;
  }
  
  public boolean isEmpty()
  {
    return (this.oJ == null) || (this.oJ.isEmpty());
  }
  
  public void jU(String paramString1, String paramString2)
  {
    if ((this.oJ != null) && (!this.oJ.isEmpty()))
    {
      Iterator localIterator = this.oJ.iterator();
      while (localIterator.hasNext())
      {
        ayjn.b localb = (ayjn.b)localIterator.next();
        if ((cA(localb.category, paramString1)) && (cA(localb.name, paramString2))) {
          a(localb);
        }
      }
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    super.setSize(paramInt1, paramInt2);
    if ((this.oJ == null) || (this.oJ.size() <= 0)) {
      ram.d(TAG, "mFaceItems = null or size<=0");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.oJ.iterator();
      while (localIterator.hasNext())
      {
        ayjn.b localb = (ayjn.b)localIterator.next();
        paramInt1 = (int)(localb.width * localb.scaleValue);
        paramInt2 = (int)(localb.height * localb.scaleValue);
        localb.centerP.x = a(localb.centerP.x, paramInt1, this.drawRect.left, this.drawRect.right);
        localb.centerP.y = a(localb.centerP.y, paramInt2, this.drawRect.top, this.drawRect.bottom);
      }
    }
  }
  
  public int tp()
  {
    if (this.oJ == null) {}
    for (int i = 0;; i = this.oJ.size())
    {
      ram.d(TAG, "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public int[] z()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext()) {
      if (((ayjn.b)localIterator.next() instanceof ayjn.a)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public final class a
    extends ayjn.b
  {
    public StaticLayout a;
    public final String aAw = "...";
    public String aAx;
    public boolean aHB;
    public int bqP;
    public Path dashPath = new Path();
    public int lineHeight;
    public String text;
    public int textColor;
    public int textSize;
    
    public a(@NonNull Drawable paramDrawable, @NonNull ayjn.d paramd, String paramString1, String paramString2, String paramString3, int paramInt)
    {
      super(paramDrawable, paramd, paramString1, paramString2, paramString3, paramInt);
      this.textSize = paramd.textSize;
      this.textColor = paramd.textColor;
      setText(paramd.text);
      this.dzB = true;
    }
    
    public a(@NonNull Drawable paramDrawable, @NonNull ayjn.d paramd, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      this(paramDrawable, paramd, paramString1, paramString2, paramString3, paramInt1);
      this.uj = paramInt2;
    }
    
    public void a(Canvas paramCanvas, boolean paramBoolean)
    {
      float f2 = this.width;
      float f1 = this.height;
      if (f2 * this.scaleValue < 200.0F) {
        f2 = 200.0F / this.scaleValue;
      }
      if (this.scaleValue * f1 < 200.0F) {
        f1 = 200.0F / this.scaleValue;
      }
      if (this.dzG) {
        paramCanvas.drawColor(Color.parseColor("#66000000"));
      }
      paramCanvas.save();
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      if (this.a.getLineCount() == 1) {
        paramCanvas.translate(0.0F, this.lineHeight);
      }
      if ((this.dzG) && (this.eGY == 0))
      {
        if (this.faceBitmap == null) {
          this.faceBitmap = ayjn.i(this.drawable);
        }
        paramCanvas.drawBitmap(this.faceBitmap.extractAlpha(ayjn.this.dk, null), null, new Rect((int)-this.FN, (int)-this.FN, this.faceBitmap.getWidth() + (int)this.FN, this.faceBitmap.getHeight() + (int)this.FN), ayjn.this.dk);
      }
      this.drawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, this.X.height());
      paramCanvas.save();
      paramCanvas.translate(6.0F, 16.0F);
      ayjn.this.mTextPaint.setTextSize(this.textSize);
      ayjn.this.mTextPaint.setColor(this.textColor);
      this.a.draw(paramCanvas);
      paramCanvas.restore();
      if (paramBoolean)
      {
        paramCanvas.save();
        paramCanvas.translate(0.0F, 10.0F);
        if (this.aHB)
        {
          ayjn.this.aX.setAlpha(this.bqP);
          paramCanvas.drawPath(this.dashPath, ayjn.this.aX);
        }
        paramCanvas.restore();
      }
      paramCanvas.translate(0.0F, this.a.getHeight() + 32);
      ayjn.this.jdField_di_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.width, 6);
      ayjn.this.jdField_di_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public void btN()
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
      localValueAnimator.setDuration(1000L);
      localValueAnimator.setRepeatCount(2);
      localValueAnimator.setRepeatMode(2);
      localValueAnimator.addUpdateListener(new ayjo(this));
      localValueAnimator.addListener(new ayjp(this));
      localValueAnimator.start();
    }
    
    public void c(TroopBarPOI paramTroopBarPOI)
    {
      this.e = paramTroopBarPOI;
      if (paramTroopBarPOI != null)
      {
        setText(paramTroopBarPOI.AU());
        this.poiUpdateTime = System.currentTimeMillis();
        return;
      }
      setText(null);
      this.poiUpdateTime = -1L;
    }
    
    public void draw(Canvas paramCanvas)
    {
      if ((this.dzE) && (this.aIp))
      {
        if (this.isAnchor) {
          paramCanvas.drawColor(Color.parseColor("#66000000"));
        }
        if ((this.isAnchor) && (this.dzH))
        {
          float f1 = this.FJ;
          float f2 = this.FH;
          float f3 = this.FK;
          float f4 = this.FI;
          float f5 = this.centerP.x;
          float f6 = this.translateXValue;
          float f7 = this.centerP.y;
          paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.translateYValue + f7, ayjn.this.jdField_di_of_type_AndroidGraphicsPaint);
        }
      }
      paramCanvas.save();
      paramCanvas.concat(ayjn.this.a.a(this));
      ayom.tw();
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      if (this.a.getLineCount() == 1) {
        paramCanvas.translate(0.0F, this.lineHeight);
      }
      this.drawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, this.X.height());
      paramCanvas.save();
      paramCanvas.translate(6.0F, 16.0F);
      ayjn.this.mTextPaint.setTextSize(this.textSize);
      ayjn.this.mTextPaint.setColor(this.textColor);
      this.a.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(0.0F, 10.0F);
      if (this.aHB)
      {
        ayjn.this.aX.setAlpha(this.bqP);
        paramCanvas.drawPath(this.dashPath, ayjn.this.aX);
      }
      paramCanvas.restore();
      paramCanvas.translate(0.0F, this.a.getHeight() + 32);
      ayjn.this.jdField_di_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.width, 6);
      ayjn.this.jdField_di_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
      int i;
      if (this.aIp)
      {
        paramCanvas.save();
        if (this.ajB != 0) {
          break label455;
        }
        i = 2130845498;
        if (this.mSegmentKeeper.isDataLocked()) {
          break label487;
        }
        if (this.ajB != 0) {
          break label463;
        }
        i = 2130845506;
      }
      label406:
      label419:
      label455:
      label463:
      label479:
      label487:
      for (;;)
      {
        int j;
        if (this.ajB == 1)
        {
          j = 2130845496;
          if (this.ajB != 2) {
            break label479;
          }
        }
        for (int k = 2130845503;; k = 2130845502)
        {
          ayom.a(paramCanvas, ayjn.this.a, this, i, j, k);
          paramCanvas.restore();
          return;
          i = 2130845497;
          break;
          i = 2130845504;
          break label406;
          j = 2130845495;
          break label419;
        }
      }
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public void setText(String paramString)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        ram.e(ayjn.TAG, "text is empty.");
        str = "";
      }
      ram.d(ayjn.TAG, "text:" + str);
      this.aAx = str;
      this.text = str;
      int j = (int)(this.width - 12.0F);
      int i = j;
      if (j < 0)
      {
        QLog.d(ayjn.TAG, 2, "faceItem setText width < 0");
        i = 0;
      }
      ayjn.this.mTextPaint.setTextSize(this.textSize);
      this.a = new StaticLayout(this.aAx, ayjn.this.mTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      if (this.a.getLineCount() > 2)
      {
        j = this.a.getLineEnd(1);
        paramString = this.aAx.substring(0, j);
        ram.d(ayjn.TAG, "subString : " + this.aAx + " -> " + paramString);
        this.aAx = paramString;
        j = this.aAx.length();
        this.aAx += "...";
        this.a = new StaticLayout(this.aAx, ayjn.this.mTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        j -= 1;
        while ((j > 0) && (this.a.getLineCount() > 2))
        {
          paramString = this.aAx.substring(0, j) + "...";
          ram.d(ayjn.TAG, "delete last char : " + this.aAx + " -> " + paramString);
          this.aAx = paramString;
          this.a = new StaticLayout(this.aAx, ayjn.this.mTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
          j -= 1;
        }
        if (j == 0) {
          ram.e(ayjn.TAG, "text size is too large :" + this.textSize);
        }
      }
      ram.d(ayjn.TAG, "final text : " + this.aAx + " , original text : " + this.text);
      paramString = new Rect();
      this.a.getLineBounds(0, paramString);
      this.lineHeight = paramString.height();
      this.dashPath.reset();
      this.dashPath.addRoundRect(new RectF(0.0F, 0.0F, this.width, this.a.getHeight() + 12), 4.0F, 4.0F, Path.Direction.CCW);
    }
  }
  
  public class b
    extends ayoo.a
  {
    public RectF X;
    public int aVB = 1;
    public final String category;
    public String data;
    public Drawable drawable;
    public boolean dzB;
    public boolean dzC;
    public TroopBarPOI e;
    public int eGY;
    public int eGZ;
    public Bitmap faceBitmap;
    public final String name;
    public final String path;
    public long poiUpdateTime = -1L;
    public int uj = 0;
    
    public b(@NonNull Drawable paramDrawable, @NonNull ayjn.d paramd, String paramString1, String paramString2, String paramString3, int paramInt)
    {
      super(paramd.scale, paramd.rotate, paramd.translateXValue, paramd.translateYValue, paramd.width, paramd.height, true);
      this.drawable = paramDrawable;
      this.category = paramString1;
      this.name = paramString2;
      this.path = paramString3;
      this.X = new RectF(paramDrawable.getBounds());
      this.dzB = false;
      this.eGY = paramInt;
    }
    
    public b(@NonNull Drawable paramDrawable, @NonNull ayjn.d paramd, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      this(paramDrawable, paramd, paramString1, paramString2, paramString3, paramInt1);
      this.uj = paramInt2;
    }
    
    private void drawEditBtn(Canvas paramCanvas)
    {
      paramCanvas.save();
      int i;
      label35:
      int k;
      label47:
      int j;
      if (this.ajB == 0)
      {
        i = 2130845498;
        if (!this.mSegmentKeeper.isDataLocked())
        {
          if (this.ajB != 0) {
            break label114;
          }
          i = 2130845506;
        }
        if (this.ajB != 1) {
          break label120;
        }
        k = 2130845496;
        if (this.ajB != 2) {
          break label127;
        }
        j = 2130845503;
        label58:
        if (this.dAg) {
          i = -1;
        }
        if (!ayjn.d(ayjn.this).a.aQQ()) {
          break label133;
        }
        j = -1;
        i = -1;
      }
      label133:
      for (;;)
      {
        ayom.a(paramCanvas, ayjn.this.a, this, i, k, j);
        paramCanvas.restore();
        return;
        i = 2130845497;
        break;
        label114:
        i = 2130845504;
        break label35;
        label120:
        k = 2130845495;
        break label47;
        label127:
        j = 2130845502;
        break label58;
      }
    }
    
    public void Zt(boolean paramBoolean)
    {
      this.dzB = paramBoolean;
    }
    
    public void Zu(boolean paramBoolean)
    {
      this.dzC = paramBoolean;
    }
    
    public void a(Canvas paramCanvas, boolean paramBoolean)
    {
      if ((!this.mSegmentKeeper.isInSegment(ayjn.e(ayjn.this).getTimeStamp())) && (!this.aIp)) {
        return;
      }
      float f2 = this.width;
      float f1 = this.height;
      if (f2 * this.scaleValue < 200.0F) {
        f2 = 200.0F / this.scaleValue;
      }
      if (this.scaleValue * f1 < 200.0F) {
        f1 = 200.0F / this.scaleValue;
      }
      if (this.dzG) {
        paramCanvas.drawColor(Color.parseColor("#66000000"));
      }
      paramCanvas.save();
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      ayjn.this.a.m(this);
      if ((this.dzG) && (this.eGY == 0))
      {
        if (this.faceBitmap == null) {
          this.faceBitmap = ayjn.i(this.drawable);
        }
        paramCanvas.drawBitmap(this.faceBitmap.extractAlpha(ayjn.this.dk, null), null, new Rect((int)-this.FN, (int)-this.FN, this.faceBitmap.getWidth() + (int)this.FN, this.faceBitmap.getHeight() + (int)this.FN), ayjn.this.dk);
      }
      this.drawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public void c(TroopBarPOI paramTroopBarPOI)
    {
      this.e = paramTroopBarPOI;
      if (paramTroopBarPOI != null)
      {
        setText(paramTroopBarPOI.AU());
        this.poiUpdateTime = System.currentTimeMillis();
        return;
      }
      setText(null);
      this.poiUpdateTime = -1L;
    }
    
    public void cancelAnimator()
    {
      if ((this.N != null) && (this.aIo)) {
        this.N.cancel();
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      if ((!this.mSegmentKeeper.isInSegment(ayjn.c(ayjn.this).getTimeStamp())) && (!this.aIp)) {}
      do
      {
        return;
        float f2 = this.width;
        float f1 = this.height;
        if (f2 * this.scaleValue < 200.0F) {
          f2 = 200.0F / this.scaleValue;
        }
        if (this.scaleValue * f1 < 200.0F) {
          f1 = 200.0F / this.scaleValue;
        }
        if ((this.dzE) && (this.aIp))
        {
          if ((this.isAnchor) && (this.dzH))
          {
            f1 = this.FJ;
            f2 = this.FH;
            float f3 = this.FK;
            float f4 = this.FI;
            float f5 = this.centerP.x;
            float f6 = this.translateXValue;
            float f7 = this.centerP.y;
            paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.translateYValue + f7, ayjn.this.di);
            paramCanvas.save();
            paramCanvas.concat(ayjn.this.a.b(this));
            int i = (int)(this.width * this.scaleValue * this.nJ) + this.bsp * 2;
            int j = (int)(this.height * this.scaleValue * this.nJ) + this.bsp * 2;
            paramCanvas.drawRect(new RectF(-i / 2, -j / 2, i / 2, j / 2), ayjn.this.dj);
            paramCanvas.restore();
          }
          if (this.isAnchor) {
            paramCanvas.drawColor(Color.parseColor("#66000000"));
          }
        }
        paramCanvas.save();
        paramCanvas.concat(ayjn.this.a.a(this));
        paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
        this.drawable.draw(paramCanvas);
        paramCanvas.restore();
        ayjn.this.a.m(this);
      } while (!this.aIp);
      drawEditBtn(paramCanvas);
    }
    
    public String getText()
    {
      if (this.e != null) {
        return this.e.AU();
      }
      return "";
    }
    
    public void setText(String paramString)
    {
      if (this.drawable != null)
      {
        if (!(this.drawable instanceof ayob)) {
          break label68;
        }
        this.drawable = aynb.a((ayob)this.drawable, ayjn.this.context, paramString);
        if (this.drawable != null) {
          this.data = ((ayob)this.drawable).getData();
        }
      }
      while (this.drawable == null)
      {
        return;
        label68:
        if ((this.drawable instanceof BitmapDrawable)) {
          this.drawable = aynb.a(this.data, ayjn.this.context, paramString);
        }
      }
      this.drawable.setBounds(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
      float f = this.centerP.x - this.scaleValue * this.drawable.getIntrinsicWidth() / 2.0F + this.translateXValue;
      if (f < azbx.dip2px(23.0F)) {
        this.centerP.x = (this.centerP.x - f + azbx.dip2px(23.0F));
      }
      this.drawable.setCallback(ayjn.f(ayjn.this));
      this.X = new RectF(this.drawable.getBounds());
      this.width = this.drawable.getIntrinsicWidth();
      this.height = this.drawable.getIntrinsicHeight();
      ((axsu)axov.a(4)).adn(paramString);
    }
    
    public void startAnimator()
    {
      if (this.N == null)
      {
        this.N = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
        this.N.setDuration(200L);
        this.N.setInterpolator(new LinearInterpolator());
        this.N.addUpdateListener(new ayjq(this));
        this.N.addListener(new ayjr(this));
      }
      if (!this.aIo) {
        this.N.start();
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(ayjn.b paramb);
    
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
    
    public abstract void xj(int paramInt);
  }
  
  public static class d
  {
    public final PointF centerP;
    public final int height;
    public final float rotate;
    public float scale;
    public final String text;
    public final int textColor;
    public final int textSize;
    public final float translateXValue;
    public final float translateYValue;
    public final int width;
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
    {
      this.centerP = new PointF(paramFloat1, paramFloat2);
      this.scale = paramFloat3;
      this.rotate = paramFloat4;
      this.translateXValue = paramFloat5;
      this.translateYValue = paramFloat6;
      this.width = paramInt1;
      this.height = paramInt2;
      this.text = "";
      this.textColor = -1;
      this.textSize = 0;
    }
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      this.centerP = new PointF(paramFloat1, paramFloat2);
      this.scale = paramFloat3;
      this.rotate = paramFloat4;
      this.translateXValue = paramFloat5;
      this.translateYValue = paramFloat6;
      this.width = paramInt1;
      this.height = paramInt2;
      this.text = paramString;
      this.textColor = paramInt3;
      this.textSize = paramInt4;
    }
    
    public static d a(@NonNull d paramd)
    {
      return new d(paramd.centerP.x, paramd.centerP.y, paramd.scale, paramd.rotate, paramd.translateXValue, paramd.translateYValue, paramd.width, paramd.height, paramd.text, paramd.textColor, paramd.textSize);
    }
    
    public static d a(@NonNull ayoo.a parama, @NonNull d paramd)
    {
      return new d(parama.centerP.x, parama.centerP.y, paramd.scale, parama.nI, parama.translateXValue, parama.translateYValue, paramd.width, paramd.height, paramd.text, paramd.textColor, paramd.textSize);
    }
    
    public String toString()
    {
      return "LayerParams{centerP=" + this.centerP + ", scale=" + this.scale + ", rotate=" + this.rotate + ", translateXValue=" + this.translateXValue + ", translateYValue=" + this.translateYValue + ", width=" + this.width + ", height=" + this.height + ", text='" + this.text + '\'' + ", textColor=" + this.textColor + ", textSize=" + this.textSize + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjn
 * JD-Core Version:    0.7.0.1
 */