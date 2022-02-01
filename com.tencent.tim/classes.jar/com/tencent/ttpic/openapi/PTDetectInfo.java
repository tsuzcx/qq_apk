package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTDetectInfo
{
  public AIAttr aiAttr;
  public double audioScaleFactor;
  public List<PointF> bodyPoints;
  public float[] catFaceAngles;
  public List<PointF> catFacePoints;
  public Frame displacementMaskFrame;
  public float[] face3DRotationArray;
  public float[] face3DVerticesArray;
  public Map<Integer, FaceActionCounter> faceActionCounter;
  public float[] faceAngles;
  public FaceActionCounterListener faceDetector;
  public float[] faceKitFaceRotation;
  public float[] faceKitFaceVertices;
  public List<PointF> facePoints;
  public FaceStatus faceStatus;
  public int[] featureIndices;
  public int frameIndex;
  public int gestureTrigger = -1;
  public Map<Integer, Integer> handActionCounter;
  public List<PointF> handPoints;
  public boolean isFreezeInfo = false;
  public boolean needRender;
  public Frame noseOcclusionFrame;
  public float phoneAngle;
  public float[] pointsVis;
  public int randomGroupValue;
  public float realPhoneAngle;
  public ArrayList<RedPacketPosition> redPacketPositions;
  public List<PointF> starPoints;
  public long timestamp;
  public Set<Integer> triggeredExpression;
  
  private PTDetectInfo() {}
  
  public PTDetectInfo(Builder paramBuilder)
  {
    this.facePoints = paramBuilder.facePoints;
    this.faceAngles = paramBuilder.faceAngles;
    this.pointsVis = paramBuilder.pointsVis;
    this.faceActionCounter = paramBuilder.faceActionCounter;
    this.handPoints = paramBuilder.handPoints;
    this.handActionCounter = paramBuilder.handActionCounter;
    this.triggeredExpression = paramBuilder.triggeredExpression;
    this.bodyPoints = paramBuilder.bodyPoints;
    this.catFacePoints = paramBuilder.catFacePoints;
    this.catFaceAngles = paramBuilder.catFaceAngles;
    this.phoneAngle = paramBuilder.phoneAngle;
    this.realPhoneAngle = paramBuilder.realPhoneAngle;
    this.timestamp = paramBuilder.timestamp;
    this.faceDetector = paramBuilder.faceDetector;
    this.starPoints = paramBuilder.starPoints;
    this.faceStatus = paramBuilder.faceStatus;
    this.gestureTrigger = paramBuilder.gestureTrigger;
    this.isFreezeInfo = paramBuilder.isFreezeInfo;
    this.faceKitFaceVertices = paramBuilder.faceKitFaceVertices;
    this.faceKitFaceRotation = paramBuilder.faceKitFaceRotation;
    this.face3DVerticesArray = paramBuilder.face3DVerticesArray;
    this.face3DRotationArray = paramBuilder.face3DRotationArray;
    this.featureIndices = paramBuilder.featureIndices;
    this.aiAttr = paramBuilder.aiAttr;
    this.noseOcclusionFrame = paramBuilder.noseOcclusionFrame;
    this.displacementMaskFrame = paramBuilder.displacementMaskFrame;
    this.randomGroupValue = paramBuilder.randomGroupValue;
    this.frameIndex = paramBuilder.frameIndex;
    this.audioScaleFactor = paramBuilder.audioScaleFactor;
    this.redPacketPositions = paramBuilder.redPacketPositions;
    this.needRender = paramBuilder.needRender;
  }
  
  public static class Builder
  {
    private AIAttr aiAttr;
    private double audioScaleFactor;
    private List<PointF> bodyPoints;
    private float[] catFaceAngles;
    private List<PointF> catFacePoints;
    private Frame displacementMaskFrame;
    private float[] face3DRotationArray;
    private float[] face3DVerticesArray;
    private Map<Integer, FaceActionCounter> faceActionCounter;
    private float[] faceAngles;
    private FaceActionCounterListener faceDetector;
    private float[] faceKitFaceRotation;
    private float[] faceKitFaceVertices;
    private List<PointF> facePoints;
    private FaceStatus faceStatus;
    private int[] featureIndices;
    private int frameIndex;
    private int gestureTrigger = -1;
    private Map<Integer, Integer> handActionCounter;
    private List<PointF> handPoints;
    private boolean isFreezeInfo = false;
    private boolean needRender;
    private Frame noseOcclusionFrame;
    private float phoneAngle;
    private float[] pointsVis;
    private int randomGroupValue;
    private float realPhoneAngle;
    private ArrayList<RedPacketPosition> redPacketPositions;
    private List<PointF> starPoints;
    private long timestamp;
    private Set<Integer> triggeredExpression;
    
    public Builder aiAttr(AIAttr paramAIAttr)
    {
      this.aiAttr = paramAIAttr;
      return this;
    }
    
    public Builder audioScaleFactor(double paramDouble)
    {
      this.audioScaleFactor = paramDouble;
      return this;
    }
    
    public Builder bodyPoints(List<PointF> paramList)
    {
      this.bodyPoints = paramList;
      return this;
    }
    
    public PTDetectInfo build()
    {
      return new PTDetectInfo(this);
    }
    
    public Builder catFaceAngles(float[] paramArrayOfFloat)
    {
      this.catFaceAngles = paramArrayOfFloat;
      return this;
    }
    
    public Builder catFacePoints(List<PointF> paramList)
    {
      this.catFacePoints = paramList;
      return this;
    }
    
    public Builder displacementMaskFrame(Frame paramFrame)
    {
      this.displacementMaskFrame = paramFrame;
      return this;
    }
    
    public Builder face3DRotationArray(float[] paramArrayOfFloat)
    {
      this.face3DRotationArray = paramArrayOfFloat;
      return this;
    }
    
    public Builder face3DVerticesArray(float[] paramArrayOfFloat)
    {
      this.face3DVerticesArray = paramArrayOfFloat;
      return this;
    }
    
    public Builder faceActionCounter(Map<Integer, FaceActionCounter> paramMap)
    {
      this.faceActionCounter = paramMap;
      return this;
    }
    
    public Builder faceAngles(float[] paramArrayOfFloat)
    {
      this.faceAngles = paramArrayOfFloat;
      return this;
    }
    
    public Builder faceDetector(FaceActionCounterListener paramFaceActionCounterListener)
    {
      this.faceDetector = paramFaceActionCounterListener;
      return this;
    }
    
    public Builder faceKitFaceRotation(float[] paramArrayOfFloat)
    {
      this.faceKitFaceRotation = paramArrayOfFloat;
      return this;
    }
    
    public Builder faceKitFaceVertices(float[] paramArrayOfFloat)
    {
      this.faceKitFaceVertices = paramArrayOfFloat;
      return this;
    }
    
    public Builder facePoints(List<PointF> paramList)
    {
      this.facePoints = paramList;
      return this;
    }
    
    public Builder faceStatus(FaceStatus paramFaceStatus)
    {
      this.faceStatus = paramFaceStatus;
      return this;
    }
    
    public Builder featureIndices(int[] paramArrayOfInt)
    {
      this.featureIndices = paramArrayOfInt;
      return this;
    }
    
    public Builder frameIndex(int paramInt)
    {
      this.frameIndex = paramInt;
      return this;
    }
    
    public Builder gestureTrigger(int paramInt)
    {
      this.gestureTrigger = paramInt;
      return this;
    }
    
    public Builder handActionCounter(Map<Integer, Integer> paramMap)
    {
      this.handActionCounter = paramMap;
      return this;
    }
    
    public Builder handPoints(List<PointF> paramList)
    {
      this.handPoints = paramList;
      return this;
    }
    
    public Builder isFreezeInfo(boolean paramBoolean)
    {
      this.isFreezeInfo = paramBoolean;
      return this;
    }
    
    public Builder needRender(boolean paramBoolean)
    {
      this.needRender = paramBoolean;
      return this;
    }
    
    public Builder noseOcclusionFrame(Frame paramFrame)
    {
      this.noseOcclusionFrame = paramFrame;
      return this;
    }
    
    public Builder phoneAngle(float paramFloat)
    {
      this.phoneAngle = paramFloat;
      return this;
    }
    
    public Builder pointsVis(Float[] paramArrayOfFloat)
    {
      if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
        return this;
      }
      float[] arrayOfFloat = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
        i += 1;
      }
      this.pointsVis = arrayOfFloat;
      return this;
    }
    
    public Builder randomGroupValue(int paramInt)
    {
      this.randomGroupValue = paramInt;
      return this;
    }
    
    public Builder realPhoneAngle(float paramFloat)
    {
      this.realPhoneAngle = paramFloat;
      return this;
    }
    
    public Builder redPacketPositions(ArrayList<RedPacketPosition> paramArrayList)
    {
      this.redPacketPositions = paramArrayList;
      return this;
    }
    
    public Builder starPoints(List<PointF> paramList)
    {
      this.starPoints = paramList;
      return this;
    }
    
    public Builder timestamp(long paramLong)
    {
      this.timestamp = paramLong;
      return this;
    }
    
    public Builder triggeredExpression(Set<Integer> paramSet)
    {
      this.triggeredExpression = paramSet;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTDetectInfo
 * JD-Core Version:    0.7.0.1
 */