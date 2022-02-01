package com.tencent.mobileqq.ar;

import acfp;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import aqnm;

public abstract class ScanningData
{
  public Paint F;
  public int FC;
  public int FD;
  public int FE;
  public int FF;
  public int FG;
  public int FH;
  public int FI;
  public int FJ;
  public int FK;
  public int FL;
  public int FM;
  public Paint G;
  public Paint H;
  public Paint I;
  public Paint J;
  public Paint K;
  public Paint L;
  public Paint M;
  private AnimatorSet V;
  private AnimatorSet W;
  private AnimatorSet X;
  private AnimatorSet Y;
  private AnimatorSet Z;
  private ObjectAnimator aX;
  private ObjectAnimator aY;
  private ObjectAnimator aZ;
  private AnimatorSet aa;
  private AnimatorSet ab;
  private AnimatorSet ac;
  private AnimatorSet ad;
  private AnimatorSet ae;
  private AnimatorSet af;
  private AnimatorSet ag;
  private AnimatorSet ah;
  private AnimatorSet ai;
  public float am;
  public float an;
  public RectF at;
  private ObjectAnimator bA;
  public Paint bA;
  private ObjectAnimator bB;
  public Paint bB;
  public Paint bC;
  public Paint bD;
  public Paint bE;
  public Paint bF;
  public Paint bG;
  public Paint bH;
  public Paint bI;
  public Paint bJ;
  public Paint bK;
  public boolean bMB;
  public boolean bMC;
  public boolean bMD;
  public boolean bMt;
  public boolean bMu;
  public float bV;
  public float bW = 1.0F;
  public float bX;
  public float bY;
  public float bZ;
  private ObjectAnimator ba;
  private ObjectAnimator bb;
  private ObjectAnimator bc;
  private ObjectAnimator bd;
  private ObjectAnimator be;
  private ObjectAnimator bf;
  private ObjectAnimator bg;
  private ObjectAnimator bh;
  private ObjectAnimator bi;
  private ObjectAnimator bj;
  private ObjectAnimator bk;
  private ObjectAnimator bl;
  private ObjectAnimator bm;
  private ObjectAnimator bn;
  private ObjectAnimator bo;
  private ObjectAnimator bp;
  private ObjectAnimator bq;
  private ObjectAnimator br;
  private ObjectAnimator bs;
  public String bsA = "YANG YANG";
  public String bsB;
  public String bsC;
  public String bsx;
  public String bsz = acfp.m(2131714002);
  private ObjectAnimator bt;
  private ObjectAnimator bu;
  private ObjectAnimator bv;
  private ObjectAnimator bw;
  private ObjectAnimator bx;
  private ObjectAnimator by;
  private ObjectAnimator bz;
  public float cA;
  public float cB;
  public float cC;
  public float cD;
  public float cE;
  public int cEj;
  public int cEk;
  public int cEl;
  public int cEm;
  public int cEn;
  public int cEo;
  public int cEp;
  public int cEq;
  public int cEr;
  public int cEs;
  public int cEt;
  public float cF;
  public float cG;
  public float cH;
  public float cI;
  public float cJ;
  public float cK;
  public float cL;
  public float cM;
  public float cN;
  public float cO;
  public float cP;
  public float cQ;
  public float cR;
  public float cS;
  public float cT;
  public float cU;
  public float cV;
  public float cW;
  public float cX;
  public float cY;
  public float cZ;
  public float ca;
  public float cb;
  public float cc;
  public float cd;
  public float ce;
  public float centerX;
  public float centerY;
  public float cf;
  public float cg;
  public float ch;
  public float ci;
  public float cj;
  public float ck;
  public float cl;
  public float cm;
  public float cn;
  public float co;
  public float cp;
  public float cq;
  public float cr;
  public float cs;
  public float ct;
  public float cu;
  public float cv;
  public float cw;
  public float cz = 1.0F;
  public float da;
  public float db;
  public float dc;
  public float dd;
  public float de;
  public float df;
  public float dg;
  public float dh;
  public float di;
  public float dj;
  public float dk;
  public float dl;
  public float dm;
  public float dn;
  public float jdField_do;
  public Bitmap eS;
  public Bitmap eT;
  public int faceID;
  public TextPaint h;
  public TextPaint i;
  public String imgUrl;
  public boolean isClicked;
  public boolean isStar;
  public float jG;
  public Context mContext;
  public float of;
  public boolean ql;
  public float scale = 1.0F;
  public float tA;
  public float tB;
  public float tC;
  public float tD;
  public float tE;
  public float tF;
  public float tG;
  public float tH;
  public float tI;
  public float tJ;
  public float tK;
  public float tL;
  public float tM;
  public float tN;
  public float tO;
  public float tP;
  public float tQ;
  public float tR = 1.0F;
  public float tS;
  public float tT;
  public float tU;
  public float tV;
  public float tW;
  public float tX;
  public float tY;
  public float tZ;
  public float ti;
  public float tj;
  public float tk;
  public float tl;
  public float tm;
  public float tn;
  public float to;
  public float tp;
  public float tq;
  public float tr;
  public float ts;
  public float tt;
  public float tu;
  public float tv;
  public float tw;
  public float tz;
  public float uA;
  public float uB;
  public float uC;
  public float uE;
  public float uF;
  public float uG;
  public float uH;
  public float uI;
  public float uJ;
  public float uK;
  public float uL;
  public float uM;
  public float ua;
  public float ub;
  public float uc;
  public float ud;
  public float ue;
  public float uf;
  public float ug;
  public float uh;
  public float ui;
  public String uin;
  public float uj;
  public float uk;
  public float ul;
  public float um;
  public float un;
  public float uo;
  public float up;
  public float uq;
  public float ur;
  public String url;
  public float us;
  public float ut;
  public float uu;
  public float uv;
  public float uw;
  public float ux;
  public float uy;
  public float uz;
  
  public ScanningData(Context paramContext)
  {
    this.mContext = paramContext;
    init();
    cRl();
  }
  
  private void init()
  {
    if (this.mContext != null)
    {
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.of = localDisplayMetrics.widthPixels;
      this.jG = localDisplayMetrics.heightPixels;
    }
    initData();
    this.F = new Paint();
    this.F.setStrokeCap(Paint.Cap.ROUND);
    this.F.setAntiAlias(true);
    this.F.setStyle(Paint.Style.STROKE);
    this.F.setDither(true);
    this.G = new Paint();
    this.G.setStrokeCap(Paint.Cap.ROUND);
    this.G.setAntiAlias(true);
    this.G.setStyle(Paint.Style.FILL);
    this.G.setDither(true);
    this.G.setStrokeWidth(a.FN);
    this.H = new Paint();
    this.H.setStrokeCap(Paint.Cap.ROUND);
    this.H.setAntiAlias(true);
    this.H.setStyle(Paint.Style.STROKE);
    this.H.setDither(true);
    this.I = new Paint();
    this.I.setStrokeCap(Paint.Cap.ROUND);
    this.I.setAntiAlias(true);
    this.I.setStyle(Paint.Style.STROKE);
    this.I.setDither(true);
    this.J = new Paint();
    this.J.setStrokeCap(Paint.Cap.ROUND);
    this.J.setAntiAlias(true);
    this.J.setStyle(Paint.Style.STROKE);
    this.J.setDither(true);
    this.K = new Paint();
    this.K.setStrokeCap(Paint.Cap.ROUND);
    this.K.setAntiAlias(true);
    this.K.setStyle(Paint.Style.STROKE);
    this.K.setDither(true);
    this.L = new Paint();
    this.L.setStrokeCap(Paint.Cap.ROUND);
    this.L.setAntiAlias(true);
    this.L.setStyle(Paint.Style.STROKE);
    this.L.setDither(true);
    this.M = new Paint();
    this.M.setStrokeCap(Paint.Cap.ROUND);
    this.M.setAntiAlias(true);
    this.M.setStyle(Paint.Style.FILL);
    this.M.setDither(true);
    this.jdField_bA_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_bA_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_bA_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_bA_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_bA_of_type_AndroidGraphicsPaint.setColor(this.cEj);
    this.h = new TextPaint(this.jdField_bA_of_type_AndroidGraphicsPaint);
    this.jdField_bB_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_bB_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_bB_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_bB_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_bB_of_type_AndroidGraphicsPaint.setColor(this.cEj);
    this.bC = new Paint();
    this.bC.setStrokeCap(Paint.Cap.SQUARE);
    this.bC.setAntiAlias(true);
    this.bC.setDither(true);
    this.bC.setColor(-1);
    this.bC.setStrokeWidth(this.tM);
    this.bD = new Paint();
    this.bD.setStrokeCap(Paint.Cap.ROUND);
    this.bD.setAntiAlias(true);
    this.bD.setDither(true);
    this.bD.setColor(-1);
    this.bE = new Paint();
    this.bE.setStrokeCap(Paint.Cap.ROUND);
    this.bE.setAntiAlias(true);
    this.bE.setStyle(Paint.Style.FILL);
    this.bE.setDither(true);
    this.bE.setColor(this.cEm);
    this.bF = new Paint();
    this.bF.setStrokeCap(Paint.Cap.SQUARE);
    this.bF.setAntiAlias(true);
    this.bF.setDither(true);
    this.bF.setColor(-16777216);
    this.bG = new Paint();
    this.bG.setStrokeCap(Paint.Cap.SQUARE);
    this.bG.setAntiAlias(true);
    this.bG.setDither(true);
    this.bG.setColor(this.cEp);
    this.i = new TextPaint(this.bG);
    this.bH = new Paint();
    this.bH.setAntiAlias(true);
    this.bH.setDither(true);
    this.bH.setColor(-1);
    this.bI = new Paint();
    this.bI.setAntiAlias(true);
    this.bI.setDither(true);
    this.bI.setStyle(Paint.Style.STROKE);
    this.bI.setColor(this.cEr);
    this.bI.setStrokeWidth(this.uu);
    this.bJ = new Paint();
    this.bJ.setAntiAlias(true);
    this.bJ.setStrokeCap(Paint.Cap.ROUND);
    this.bJ.setDither(true);
    this.bJ.setStyle(Paint.Style.FILL);
    this.bJ.setColor(this.cEs);
    this.bK = new Paint();
    this.bK.setAntiAlias(true);
    this.bK.setDither(true);
    this.bK.setStyle(Paint.Style.STROKE);
    this.bK.setColor(this.cEt);
    this.bK.setStrokeWidth(this.uy);
  }
  
  public void cRl() {}
  
  public void cRr()
  {
    this.us = 0.0F;
    if (this.bMt)
    {
      cRx();
      cRs();
      return;
    }
    cRt();
    cRv();
  }
  
  @TargetApi(11)
  public void cRs()
  {
    cRu();
    this.V.start();
    this.W.start();
    this.X.start();
    this.Y.start();
    this.Z.start();
    this.aa.start();
  }
  
  @TargetApi(11)
  public void cRt()
  {
    if ((this.V != null) && (this.V.isRunning())) {
      this.V.end();
    }
    if ((this.W != null) && (this.W.isRunning())) {
      this.W.end();
    }
    if ((this.X != null) && (this.X.isRunning())) {
      this.X.end();
    }
    if ((this.Y != null) && (this.Y.isRunning())) {
      this.Y.end();
    }
    if ((this.Z != null) && (this.Z.isRunning())) {
      this.Z.end();
    }
    if ((this.aa != null) && (this.aa.isRunning())) {
      this.aa.end();
    }
  }
  
  @TargetApi(11)
  public void cRu()
  {
    if (this.aX == null)
    {
      this.aX = ObjectAnimator.ofFloat(this, "bCWidth", new float[] { aqnm.dip2px(5.0F) * this.scale, a.FO * this.scale });
      this.aX.setInterpolator(new LinearInterpolator());
      this.aX.setDuration(600L);
    }
    if (this.aY == null)
    {
      this.aY = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 1.8F, 1.0F });
      this.aY.setInterpolator(new LinearInterpolator());
      this.aY.setDuration(600L);
    }
    if (this.aZ == null)
    {
      this.aZ = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 0.0F, -360.0F });
      this.aZ.setInterpolator(new LinearInterpolator());
      this.aZ.setDuration(12000L);
      this.aZ.setRepeatCount(-1);
    }
    if (this.ba == null)
    {
      if (this.bMB)
      {
        this.ba = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.05F, 0.9974999F });
        this.ba.setInterpolator(new LinearInterpolator());
        this.ba.setDuration(200L);
      }
    }
    else
    {
      if (this.V == null)
      {
        this.V = new AnimatorSet();
        this.V.play(this.aX).with(this.aY).with(this.aZ).with(this.ba);
      }
      if (this.bb == null)
      {
        this.bb = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 1.0F, 0.0F });
        this.bb.setInterpolator(new LinearInterpolator());
        this.bb.setDuration(600L);
      }
      if (this.W == null)
      {
        this.W = new AnimatorSet();
        this.W.play(this.bb);
      }
      if (this.bc == null)
      {
        this.bc = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { 0.0F, 360.0F });
        this.bc.setInterpolator(new LinearInterpolator());
        this.bc.setDuration(12000L);
        this.bc.setRepeatCount(-1);
      }
      if (this.bd == null)
      {
        this.bd = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 1.0F, 0.0F });
        this.bd.setInterpolator(new LinearInterpolator());
        this.bd.setDuration(600L);
      }
      if (this.be == null)
      {
        if (!this.bMB) {
          break label1052;
        }
        this.be = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.05F, 0.9974999F });
        label551:
        this.be.setInterpolator(new LinearInterpolator());
        this.be.setDuration(200L);
      }
      if (this.X == null)
      {
        this.X = new AnimatorSet();
        this.X.play(this.bc).with(this.bd).with(this.be);
      }
      if (this.bf == null)
      {
        this.bf = ObjectAnimator.ofFloat(this, "sCAlpha", new float[] { 0.9F, 0.0F });
        this.bf.setInterpolator(new LinearInterpolator());
        this.bf.setDuration(600L);
      }
      if (this.bg == null)
      {
        if (!this.bMB) {
          break label1081;
        }
        this.bg = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 1.05F, 0.9974999F });
        label716:
        this.bg.setInterpolator(new LinearInterpolator());
        this.bg.setDuration(200L);
      }
      if (this.Y == null)
      {
        this.Y = new AnimatorSet();
        this.Y.play(this.bf).with(this.bg);
      }
      if (this.bh == null)
      {
        this.bh = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 0.6F, 0.0F });
        this.bh.setInterpolator(new LinearInterpolator());
        this.bh.setDuration(600L);
      }
      if (this.bi == null) {
        if (!this.bMB) {
          break label1110;
        }
      }
    }
    label1052:
    label1081:
    label1110:
    for (this.bi = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 1.05F, 0.9974999F });; this.bi = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 0.9F, 0.855F }))
    {
      this.bi.setInterpolator(new LinearInterpolator());
      this.bi.setDuration(200L);
      if (this.Z == null)
      {
        this.Z = new AnimatorSet();
        this.Z.play(this.bh).with(this.bi);
      }
      if (this.bj == null)
      {
        this.bj = ObjectAnimator.ofFloat(this, "otherScale", new float[] { 1.0F, 0.95F });
        this.bj.setInterpolator(new LinearInterpolator());
        this.bj.setDuration(200L);
      }
      if (this.aa == null)
      {
        this.aa = new AnimatorSet();
        this.aa.play(this.bj);
      }
      return;
      this.ba = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 0.9F, 0.855F });
      break;
      this.be = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 0.9F, 0.855F });
      break label551;
      this.bg = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 0.9F, 0.855F });
      break label716;
    }
  }
  
  @TargetApi(11)
  public void cRv()
  {
    cRw();
    this.ab.start();
    this.ac.start();
    this.ad.start();
    this.ae.start();
    this.af.start();
    this.ag.start();
    this.ai.start();
    this.ah.start();
  }
  
  @TargetApi(11)
  public void cRw()
  {
    if (this.bk == null)
    {
      this.bk = ObjectAnimator.ofFloat(this, "bCWidth", new float[] { a.FO * this.scale, a.FP * this.scale });
      this.bk.setInterpolator(new LinearInterpolator());
      this.bk.setDuration(600L);
    }
    if (this.bl == null)
    {
      this.bl = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 0.5F, 0.9F });
      this.bl.setInterpolator(new LinearInterpolator());
      this.bl.setDuration(600L);
    }
    if (this.bm == null)
    {
      this.bm = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 0.0F, -360.0F });
      this.bm.setInterpolator(new LinearInterpolator());
      this.bm.setRepeatCount(-1);
      this.bm.setDuration(12000L);
    }
    if (this.bn == null)
    {
      if (this.bMB)
      {
        this.bn = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 1.05F });
        this.bn.setInterpolator(new LinearInterpolator());
        this.bn.setDuration(200L);
      }
    }
    else
    {
      if (this.ab == null)
      {
        this.ab = new AnimatorSet();
        this.ab.play(this.bk).with(this.bl).with(this.bm).with(this.bn);
      }
      if (this.bo == null)
      {
        this.bo = ObjectAnimator.ofFloat(this, "maskScale", new float[] { 0.0F, 1.0F });
        this.bo.setInterpolator(new LinearInterpolator());
        this.bo.setDuration(80L);
      }
      if (this.bp == null)
      {
        this.bp = ObjectAnimator.ofFloat(this, "maskScale", new float[] { 1.0F, 0.0F });
        this.bp.setInterpolator(new LinearInterpolator());
        this.bp.setDuration(320L);
      }
      if (this.ac == null)
      {
        this.ac = new AnimatorSet();
        this.ac.play(this.bo).before(this.bp);
        this.ac.setStartDelay(320L);
      }
      if (this.bq == null)
      {
        this.bq = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 0.0F, 1.0F });
        this.bq.setInterpolator(new LinearInterpolator());
        this.bq.setDuration(600L);
      }
      if (this.ad == null)
      {
        this.ad = new AnimatorSet();
        this.ad.play(this.bq);
      }
      if (this.br == null)
      {
        this.br = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { 0.0F, 360.0F });
        this.br.setInterpolator(new LinearInterpolator());
        this.br.setDuration(6000L);
        this.br.setRepeatCount(-1);
      }
      if (this.bs == null)
      {
        this.bs = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 0.0F, 100.0F });
        this.bs.setInterpolator(new LinearInterpolator());
        this.bs.setDuration(600L);
      }
      if (this.bt == null)
      {
        if (!this.bMB) {
          break label1440;
        }
        this.bt = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 1.05F });
        label703:
        this.bt.setInterpolator(new LinearInterpolator());
        this.bt.setDuration(200L);
      }
      if (this.ae == null)
      {
        this.ae = new AnimatorSet();
        this.ae.play(this.br).with(this.bs).with(this.bt);
      }
      if (this.bu == null)
      {
        this.bu = ObjectAnimator.ofFloat(this, "sCAlpha", new float[] { 0.0F, 1.0F });
        this.bu.setInterpolator(new LinearInterpolator());
        this.bu.setDuration(600L);
      }
      if (this.bv == null)
      {
        if (!this.bMB) {
          break label1469;
        }
        this.bv = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 1.0F, 1.05F });
        label864:
        this.bv.setInterpolator(new LinearInterpolator());
        this.bv.setDuration(200L);
      }
      if (this.af == null)
      {
        this.af = new AnimatorSet();
        this.af.play(this.bu).with(this.bv);
      }
      if (this.bw == null)
      {
        this.bw = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 0.0F, 1.0F });
        this.bw.setInterpolator(new LinearInterpolator());
        this.bw.setDuration(600L);
      }
      if (this.bx == null) {
        if (!this.bMB) {
          break label1498;
        }
      }
    }
    label1440:
    label1469:
    label1498:
    for (this.bx = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 1.0F, 1.05F });; this.bx = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 0.855F, 0.9F }))
    {
      this.bx.setInterpolator(new LinearInterpolator());
      this.bx.setDuration(200L);
      if (this.ag == null)
      {
        this.ag = new AnimatorSet();
        this.ag.play(this.bw).with(this.bx);
      }
      if (this.jdField_bB_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_bB_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "otherScale", new float[] { 0.95F, 1.0F });
        this.jdField_bB_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
        this.jdField_bB_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
      }
      if (this.ai == null)
      {
        this.ai = new AnimatorSet();
        this.ai.play(this.jdField_bB_of_type_AndroidAnimationObjectAnimator);
      }
      if (this.by == null)
      {
        this.by = ObjectAnimator.ofFloat(this, "fPAlpha", new float[] { 0.0F, 1.0F });
        this.by.setInterpolator(new LinearInterpolator());
        this.by.setDuration(280L);
      }
      if (this.bz == null)
      {
        this.bz = ObjectAnimator.ofFloat(this, "fPOutCircleAlpha", new float[] { 1.0F, 0.0F, 0.0F });
        this.bz.setInterpolator(new LinearInterpolator());
        this.bz.setDuration(1500L);
        this.bz.setRepeatCount(-1);
      }
      if (this.jdField_bA_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_bA_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "fPOutCircleScale", new float[] { 1.0F, 1.3F, 1.3F });
        this.jdField_bA_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
        this.jdField_bA_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
        this.jdField_bA_of_type_AndroidAnimationObjectAnimator.setDuration(1500L);
      }
      if (this.ah == null)
      {
        this.ah = new AnimatorSet();
        this.ah.play(this.by).with(this.bz).with(this.jdField_bA_of_type_AndroidAnimationObjectAnimator);
        this.ah.setStartDelay(2200L);
      }
      return;
      this.bn = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 0.855F, 0.9F });
      break;
      this.bt = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 0.855F, 0.9F });
      break label703;
      this.bv = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 0.855F, 0.9F });
      break label864;
    }
  }
  
  @TargetApi(11)
  public void cRx()
  {
    if ((this.ab != null) && (this.ab.isRunning())) {
      this.ab.end();
    }
    if ((this.ac != null) && (this.ac.isRunning())) {
      this.ac.end();
    }
    if ((this.ad != null) && (this.ad.isRunning())) {
      this.ad.end();
    }
    if ((this.ae != null) && (this.ae.isRunning())) {
      this.ae.end();
    }
    if ((this.af != null) && (this.af.isRunning())) {
      this.af.end();
    }
    if ((this.ag != null) && (this.ag.isRunning())) {
      this.ag.end();
    }
    if ((this.ai != null) && (this.ai.isRunning())) {
      this.ai.end();
    }
    if ((this.ah != null) && (this.ah.isRunning())) {
      this.ah.end();
    }
  }
  
  public abstract void gd(boolean paramBoolean);
  
  public void initData()
  {
    this.bV = a.FY;
    this.bY = a.FP;
    this.bZ = 234.0F;
    this.ca = 36.0F;
    this.cb = 54.0F;
    this.cc = 216.0F;
    this.FC = Color.argb(255, 30, 255, 236);
    this.FD = Color.argb(255, 0, 191, 255);
    this.cd = a.FQ;
    this.ce = ((this.bZ + this.cc) / 2.0F);
    this.cf = ((this.ca + this.cb) / 2.0F);
    this.FE = Color.argb(255, 30, 255, 236);
    this.FF = Color.argb(255, 0, 191, 255);
    this.FG = Color.argb(255, 30, 255, 236);
    this.cl = 0.0F;
    this.ck = 0.0F;
    this.cm = a.FZ;
    this.cp = a.FO;
    this.cq = 160.0F;
    this.cr = 290.0F;
    this.cs = 340.0F;
    this.ct = 110.0F;
    this.FH = -1;
    this.cu = 102.0F;
    this.cv = a.cEU;
    this.cw = a.FV;
    this.cB = a.FX;
    this.cC = a.FN;
    this.cD = 32.0F;
    this.cE = 138.0F;
    this.cF = 272.0F;
    this.cG = 18.0F;
    this.cH = 152.0F;
    this.cI = 258.0F;
    this.FI = -1;
    this.cJ = 0.0F;
    this.cK = a.FV;
    this.cL = a.FO;
    this.cM = 60.0F;
    this.cN = 100.0F;
    this.cO = 300.0F;
    this.cP = 340.0F;
    this.cQ = 180.0F;
    this.cR = 220.0F;
    this.FJ = -1;
    this.cS = 0.0F;
    this.cT = a.FV;
    this.cV = a.FU;
    this.FK = -1;
    this.cW = 0.0F;
    this.cZ = a.FT;
    this.da = a.FN;
    this.db = 183.0F;
    this.dc = 267.0F;
    this.dd = 93.0F;
    this.de = 177.0F;
    this.df = 273.0F;
    this.dg = 357.0F;
    this.dh = 3.0F;
    this.di = 87.0F;
    this.FL = -1;
    this.dj = 0.0F;
    this.dl = a.FO;
    this.FM = -1;
    this.dm = 0.0F;
    this.jdField_do = a.FS;
    this.cEj = -1;
    this.tq = a.cEJ;
    this.tm = a.cEO;
    this.tn = a.FU;
    this.tu = a.cEJ;
    this.tv = a.cEJ;
    this.tw = a.cED;
    this.tA = a.cEE;
    this.tB = a.cEE;
    this.tC = a.FR;
    this.tq = a.cEE;
    this.tD = a.FS;
    this.tE = a.cEA;
    this.tF = 0.0F;
    this.tI = a.cEA;
    this.tJ = a.FN;
    this.cEk = Color.argb(102, 0, 0, 0);
    this.tK = 270.0F;
    this.tL = 40.0F;
    this.tM = a.cEu;
    this.tO = a.cEM;
    this.tP = a.cEC;
    this.tQ = a.cEx;
    this.tS = a.cEv;
    this.tU = 0.0F;
    this.tV = 0.0F;
    this.tW = a.cET;
    this.tX = a.cEO;
    this.cEm = Color.argb(229, 255, 255, 255);
    this.cEn = Color.argb(229, 255, 255, 255);
    this.cEo = Color.argb(127, 255, 255, 255);
    this.tY = a.FQ;
    this.tZ = a.cEF;
    this.uh = a.cEL;
    this.ua = a.cEF;
    this.ub = a.cEF;
    this.uc = a.cEy;
    this.ud = a.cEy;
    this.ui = a.cEF;
    this.ue = a.FR;
    this.uf = a.cED;
    this.ug = a.cEF;
    this.uj = a.cEF;
    this.uk = a.cEE;
    this.ul = a.cED;
    this.um = a.cEB;
    this.cEp = Color.argb(255, 119, 119, 119);
    this.un = a.FP;
    this.uo = a.cEE;
    this.up = a.cEw;
    this.cEq = Color.argb(76, 0, 104, 144);
    this.uq = a.cEz;
    this.ur = a.FQ;
    this.us = 0.0F;
    this.ut = a.cER;
    this.uu = a.cEw;
    this.cEr = -1;
    this.uv = a.FP;
    this.cEs = -1;
    this.uw = 120.0F;
    this.ux = a.cEK;
    this.uy = a.FO;
    this.cEt = -1;
    this.uz = 0.0F;
    this.uA = 0.0F;
    this.uB = a.cEH;
    this.uC = a.cEP;
    this.ti = a.FS;
    this.tG = 0.0F;
    this.tH = 0.0F;
    this.tN = 0.0F;
    this.tT = 0.0F;
    this.cEl = 0;
    this.cl = 0.0F;
    this.ck = 0.0F;
    this.cu = 0.0F;
    this.dj = 0.0F;
    this.dm = 0.0F;
    this.cW = 0.0F;
    this.cJ = 0.0F;
    this.cS = 0.0F;
  }
  
  public void k(float paramFloat)
  {
    this.scale = paramFloat;
    this.bV *= paramFloat;
    this.bY *= paramFloat;
    this.cd *= paramFloat;
    this.cm *= paramFloat;
    this.cp *= paramFloat;
    this.cw *= paramFloat;
    this.cC *= paramFloat;
    this.cK *= paramFloat;
    this.cL *= paramFloat;
    this.cT *= paramFloat;
    this.cV *= paramFloat;
    this.cZ *= paramFloat;
    this.da *= paramFloat;
    this.dl *= paramFloat;
    this.jdField_do *= paramFloat;
    this.tq *= paramFloat;
    this.tm *= paramFloat;
    this.tn *= paramFloat;
    this.tv *= paramFloat;
    this.tw *= paramFloat;
    this.tB *= paramFloat;
    this.tC *= paramFloat;
    this.ts = (this.tu * paramFloat);
    this.tz = (this.tA * paramFloat);
    this.tq *= paramFloat;
    this.tD *= paramFloat;
    this.tE *= paramFloat;
    this.tF *= paramFloat;
    this.tI *= paramFloat;
    this.tJ *= paramFloat;
    this.tM *= paramFloat;
    this.tO *= paramFloat;
    this.tP *= paramFloat;
    this.tQ *= paramFloat;
    this.tS *= paramFloat;
    this.ut *= paramFloat;
    this.uu *= paramFloat;
    this.uv *= paramFloat;
    this.ux *= paramFloat;
    this.uy *= paramFloat;
    this.uB *= paramFloat;
    this.uC *= paramFloat;
  }
  
  public void reset()
  {
    this.bV = a.FY;
    this.bY = a.FP;
    this.cd = a.FQ;
    this.cm = a.FZ;
    this.cp = a.FO;
    this.cw = a.FV;
    this.cB = a.FX;
    this.cC = a.FN;
    this.cK = a.FV;
    this.cL = a.FO;
    this.cT = a.FV;
    this.cV = a.FU;
    this.cZ = a.FT;
    this.da = a.FN;
    this.dl = a.FO;
    this.jdField_do = a.FS;
    this.tq = a.cEJ;
    this.tm = a.cEO;
    this.tn = a.FU;
    this.tu = a.cEJ;
    this.tv = a.cEJ;
    this.tw = a.cED;
    this.tA = a.cEE;
    this.tB = a.cEE;
    this.tC = a.FR;
    this.tq = a.cEE;
    this.tD = a.FS;
    this.tE = a.cEA;
    this.tF = 0.0F;
    this.tI = a.cEA;
    this.tJ = a.FN;
    this.tM = a.cEu;
    this.tO = a.cEM;
    this.tP = a.cEC;
    this.tQ = a.cEx;
    this.tS = a.cEv;
    this.ut = a.cER;
    this.uu = a.cEw;
    this.uv = a.FP;
    this.ux = a.cEK;
    this.uy = a.FO;
    this.uB = a.cEH;
    this.uC = a.cEP;
  }
  
  public void setBCAlpha(float paramFloat)
  {
    this.cl = paramFloat;
  }
  
  public void setBCColor(int paramInt)
  {
    this.FG = paramInt;
  }
  
  public void setBCRotate(float paramFloat)
  {
    this.bX = paramFloat;
  }
  
  public void setBCScale(float paramFloat)
  {
    this.bW = paramFloat;
  }
  
  public void setBCWidth(float paramFloat)
  {
    this.bY = paramFloat;
  }
  
  public void setBTAlpha(float paramFloat)
  {
    this.ck = paramFloat;
  }
  
  public void setCenterX(float paramFloat)
  {
    this.centerX = paramFloat;
  }
  
  public void setCenterY(float paramFloat)
  {
    this.centerY = paramFloat;
  }
  
  public void setFCAlpha(float paramFloat)
  {
    this.tV = paramFloat;
  }
  
  public void setFCPositionY(float paramFloat)
  {
    this.tU = paramFloat;
  }
  
  public void setFLAlpha(float paramFloat)
  {
    this.tN = paramFloat;
  }
  
  public void setFLPAlpha(float paramFloat)
  {
    this.tT = paramFloat;
  }
  
  public void setFNCHAlpha(float paramFloat)
  {
    this.tG = paramFloat;
  }
  
  public void setFNENAlpha(float paramFloat)
  {
    this.tH = paramFloat;
  }
  
  public void setFPAlpha(float paramFloat)
  {
    this.us = paramFloat;
  }
  
  public void setFPOutCircleAlpha(float paramFloat)
  {
    this.uz = paramFloat;
  }
  
  public void setFPOutCircleScale(float paramFloat)
  {
    this.uA = paramFloat;
  }
  
  public void setIBCAlpha(float paramFloat)
  {
    this.cJ = paramFloat;
  }
  
  public void setIBCRotate(float paramFloat)
  {
    this.cA = paramFloat;
  }
  
  public void setIBCScale(float paramFloat)
  {
    this.cz = paramFloat;
  }
  
  public void setISCAlpha(float paramFloat)
  {
    this.cS = paramFloat;
  }
  
  public void setMainFace(boolean paramBoolean)
  {
    this.bMt = paramBoolean;
  }
  
  public void setMaskScale(float paramFloat)
  {
    this.dn = paramFloat;
  }
  
  public void setOCAlpha(float paramFloat)
  {
    this.cu = paramFloat;
  }
  
  public void setOCRotate(float paramFloat)
  {
    this.co = paramFloat;
  }
  
  public void setOCScale(float paramFloat)
  {
    this.cn = paramFloat;
  }
  
  public void setOtherScale(float paramFloat)
  {
    this.tR = paramFloat;
  }
  
  public void setSCAlpha(float paramFloat)
  {
    this.dj = paramFloat;
  }
  
  public void setSCRotate(float paramFloat)
  {
    this.cY = paramFloat;
  }
  
  public void setSCScale(float paramFloat)
  {
    this.cX = paramFloat;
  }
  
  public void setSDAlpha(float paramFloat)
  {
    this.dm = paramFloat;
  }
  
  public void setSDScale(float paramFloat)
  {
    this.dk = paramFloat;
  }
  
  public void setTCAlpha(float paramFloat)
  {
    this.cW = paramFloat;
  }
  
  public void setTCScale(float paramFloat)
  {
    this.cU = paramFloat;
  }
  
  public abstract void stopAnimation();
  
  public static final class a
  {
    public static final int FN;
    public static final int FO;
    public static final int FP;
    public static final int FQ;
    public static final int FR;
    public static final int FS;
    public static final int FT;
    public static final int FU;
    public static final int FV;
    public static final int FX;
    public static final int FY;
    public static final int FZ = aqnm.dip2px(105.5F);
    public static final int cEA;
    public static final int cEB;
    public static final int cEC;
    public static final int cED;
    public static final int cEE;
    public static final int cEF;
    public static final int cEG;
    public static final int cEH;
    public static final int cEI;
    public static final int cEJ;
    public static final int cEK;
    public static final int cEL;
    public static final int cEM;
    public static final int cEN;
    public static final int cEO;
    public static final int cEP;
    public static final int cEQ;
    public static final int cER;
    public static final int cES;
    public static final int cET;
    public static final int cEU = aqnm.dip2px(120.0F);
    public static final int cEu = aqnm.dip2px(0.5F);
    public static final int cEv;
    public static final int cEw;
    public static final int cEx;
    public static final int cEy;
    public static final int cEz;
    
    static
    {
      FN = aqnm.dip2px(1.0F);
      FO = aqnm.dip2px(1.5F);
      cEv = aqnm.dip2px(1.75F);
      cEw = aqnm.dip2px(2.0F);
      cEx = aqnm.dip2px(3.0F);
      cEy = aqnm.dip2px(4.0F);
      FP = aqnm.dip2px(5.0F);
      FQ = aqnm.dip2px(6.0F);
      FR = aqnm.dip2px(8.0F);
      FS = aqnm.dip2px(10.0F);
      cEz = aqnm.dip2px(11.0F);
      cEA = aqnm.dip2px(12.0F);
      cEB = aqnm.dip2px(14.0F);
      cEC = aqnm.dip2px(15.0F);
      cED = aqnm.dip2px(16.0F);
      FT = aqnm.dip2px(16.5F);
      cEE = aqnm.dip2px(18.0F);
      cEF = aqnm.dip2px(20.0F);
      cEG = aqnm.dip2px(25.0F);
      FU = aqnm.dip2px(30.0F);
      cEH = aqnm.dip2px(34.0F);
      cEI = aqnm.dip2px(35.0F);
      cEJ = aqnm.dip2px(36.0F);
      cEK = aqnm.dip2px(38.0F);
      cEL = aqnm.dip2px(40.0F);
      cEM = aqnm.dip2px(45.0F);
      cEN = aqnm.dip2px(48.0F);
      cEO = aqnm.dip2px(60.0F);
      cEP = aqnm.dip2px(64.0F);
      cEQ = aqnm.dip2px(74.0F);
      cER = aqnm.dip2px(76.0F);
      FV = aqnm.dip2px(77.5F);
      FX = aqnm.dip2px(87.5F);
      FY = aqnm.dip2px(92.5F);
      cES = aqnm.dip2px(93.0F);
      cET = aqnm.dip2px(100.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningData
 * JD-Core Version:    0.7.0.1
 */