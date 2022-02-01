package com.tencent.ttpic.particle;

import java.util.ArrayList;

public class ParticleConfig
{
  public ParticleEmitterConfigBean particleEmitterConfig;
  
  public ParticleEmitterConfigBean getParticleEmitterConfig()
  {
    return this.particleEmitterConfig;
  }
  
  public void setParticleEmitterConfig(ParticleEmitterConfigBean paramParticleEmitterConfigBean)
  {
    this.particleEmitterConfig = paramParticleEmitterConfigBean;
  }
  
  public static class ParticleEmitterConfigBean
  {
    public AbsolutePositionBean absolutePosition;
    public AngleBean angle;
    public Angle3DBean angle3d;
    public AngleVarianceBean angleVariance;
    public BlendFuncDestinationBean blendFuncDestination;
    public BlendFuncSourceBean blendFuncSource;
    public DurationBean duration;
    public Emission3DVector emission3DVector;
    public Emission3DVectorVariance emission3DVectorVariance;
    public int emissionRate;
    public EmitterTypeBean emitterType;
    public FinishColorBean finishColor;
    public FinishColorVarianceBean finishColorVariance;
    public FinishParticleSizeBean finishParticleSize;
    public FinishParticleSizeVarianceBean finishParticleSizeVariance;
    public GravityBean gravity;
    public MaxParticlesBean maxParticles;
    public MaxRadiusBean maxRadius;
    public MaxRadiusVarianceBean maxRadiusVariance;
    public MinRadiusBean minRadius;
    public MinRadiusVarianceBean minRadiusVariance;
    public ParticleLifeSpanBean particleLifeSpan;
    public ParticleLifespanVarianceBean particleLifespanVariance;
    public ParticlePath particlePath;
    public RadialAccelVarianceBean radialAccelVariance;
    public RadialAccelerationBean radialAcceleration;
    public RotatePerSecondBean rotatePerSecond;
    public RotatePerSecondVarianceBean rotatePerSecondVariance;
    public RotationEndBean rotationEnd;
    public RotationEndVarianceBean rotationEndVariance;
    public RotationStartBean rotationStart;
    public RotationStartVarianceBean rotationStartVariance;
    public SourcePositionBean sourcePosition;
    public SourcePositionVarianceBean sourcePositionVariance;
    public SpeedBean speed;
    public SpeedVarianceBean speedVariance;
    public ArrayList<Sprite> sprites;
    public StartColorBean startColor;
    public StartColorVarianceBean startColorVariance;
    public StartParticleSizeBean startParticleSize;
    public StartParticleSizeVarianceBean startParticleSizeVariance;
    public TangentialAccelVarianceBean tangentialAccelVariance;
    public TangentialAccelerationBean tangentialAcceleration;
    public TextureBean texture;
    public YCoordFlippedBean yCoordFlipped;
    
    public Angle3DBean getAngle3d()
    {
      return this.angle3d;
    }
    
    public MaxParticlesBean getMaxParticles()
    {
      return this.maxParticles;
    }
    
    public ParticlePath getParticlePath()
    {
      return this.particlePath;
    }
    
    public ArrayList<Sprite> getSprite()
    {
      return this.sprites;
    }
    
    public void setAbsolutePosition(AbsolutePositionBean paramAbsolutePositionBean)
    {
      this.absolutePosition = paramAbsolutePositionBean;
    }
    
    public void setAngle(AngleBean paramAngleBean)
    {
      this.angle = paramAngleBean;
    }
    
    public void setAngle3d(Angle3DBean paramAngle3DBean)
    {
      this.angle3d = paramAngle3DBean;
    }
    
    public void setAngleVariance(AngleVarianceBean paramAngleVarianceBean)
    {
      this.angleVariance = paramAngleVarianceBean;
    }
    
    public void setBlendFuncDestination(BlendFuncDestinationBean paramBlendFuncDestinationBean)
    {
      this.blendFuncDestination = paramBlendFuncDestinationBean;
    }
    
    public void setBlendFuncSource(BlendFuncSourceBean paramBlendFuncSourceBean)
    {
      this.blendFuncSource = paramBlendFuncSourceBean;
    }
    
    public void setDuration(DurationBean paramDurationBean)
    {
      this.duration = paramDurationBean;
    }
    
    public void setEmitterType(EmitterTypeBean paramEmitterTypeBean)
    {
      this.emitterType = paramEmitterTypeBean;
    }
    
    public void setFinishColor(FinishColorBean paramFinishColorBean)
    {
      this.finishColor = paramFinishColorBean;
    }
    
    public void setFinishColorVariance(FinishColorVarianceBean paramFinishColorVarianceBean)
    {
      this.finishColorVariance = paramFinishColorVarianceBean;
    }
    
    public void setFinishParticleSize(FinishParticleSizeBean paramFinishParticleSizeBean)
    {
      this.finishParticleSize = paramFinishParticleSizeBean;
    }
    
    public void setFinishParticleSizeVariance(FinishParticleSizeVarianceBean paramFinishParticleSizeVarianceBean)
    {
      this.finishParticleSizeVariance = paramFinishParticleSizeVarianceBean;
    }
    
    public void setGravity(GravityBean paramGravityBean)
    {
      this.gravity = paramGravityBean;
    }
    
    public void setMaxParticles(MaxParticlesBean paramMaxParticlesBean)
    {
      this.maxParticles = paramMaxParticlesBean;
    }
    
    public void setMaxRadius(MaxRadiusBean paramMaxRadiusBean)
    {
      this.maxRadius = paramMaxRadiusBean;
    }
    
    public void setMaxRadiusVariance(MaxRadiusVarianceBean paramMaxRadiusVarianceBean)
    {
      this.maxRadiusVariance = paramMaxRadiusVarianceBean;
    }
    
    public void setMinRadius(MinRadiusBean paramMinRadiusBean)
    {
      this.minRadius = paramMinRadiusBean;
    }
    
    public void setMinRadiusVariance(MinRadiusVarianceBean paramMinRadiusVarianceBean)
    {
      this.minRadiusVariance = paramMinRadiusVarianceBean;
    }
    
    public void setParticleLifeSpan(ParticleLifeSpanBean paramParticleLifeSpanBean)
    {
      this.particleLifeSpan = paramParticleLifeSpanBean;
    }
    
    public void setParticleLifespanVariance(ParticleLifespanVarianceBean paramParticleLifespanVarianceBean)
    {
      this.particleLifespanVariance = paramParticleLifespanVarianceBean;
    }
    
    public void setParticlePath(ParticlePath paramParticlePath)
    {
      this.particlePath = paramParticlePath;
    }
    
    public void setRadialAccelVariance(RadialAccelVarianceBean paramRadialAccelVarianceBean)
    {
      this.radialAccelVariance = paramRadialAccelVarianceBean;
    }
    
    public void setRadialAcceleration(RadialAccelerationBean paramRadialAccelerationBean)
    {
      this.radialAcceleration = paramRadialAccelerationBean;
    }
    
    public void setRotatePerSecond(RotatePerSecondBean paramRotatePerSecondBean)
    {
      this.rotatePerSecond = paramRotatePerSecondBean;
    }
    
    public void setRotatePerSecondVariance(RotatePerSecondVarianceBean paramRotatePerSecondVarianceBean)
    {
      this.rotatePerSecondVariance = paramRotatePerSecondVarianceBean;
    }
    
    public void setRotationEnd(RotationEndBean paramRotationEndBean)
    {
      this.rotationEnd = paramRotationEndBean;
    }
    
    public void setRotationEndVariance(RotationEndVarianceBean paramRotationEndVarianceBean)
    {
      this.rotationEndVariance = paramRotationEndVarianceBean;
    }
    
    public void setRotationStart(RotationStartBean paramRotationStartBean)
    {
      this.rotationStart = paramRotationStartBean;
    }
    
    public void setRotationStartVariance(RotationStartVarianceBean paramRotationStartVarianceBean)
    {
      this.rotationStartVariance = paramRotationStartVarianceBean;
    }
    
    public void setSourcePosition(SourcePositionBean paramSourcePositionBean)
    {
      this.sourcePosition = paramSourcePositionBean;
    }
    
    public void setSourcePositionVariance(SourcePositionVarianceBean paramSourcePositionVarianceBean)
    {
      this.sourcePositionVariance = paramSourcePositionVarianceBean;
    }
    
    public void setSpeed(SpeedBean paramSpeedBean)
    {
      this.speed = paramSpeedBean;
    }
    
    public void setSpeedVariance(SpeedVarianceBean paramSpeedVarianceBean)
    {
      this.speedVariance = paramSpeedVarianceBean;
    }
    
    public void setSprite(ArrayList<Sprite> paramArrayList)
    {
      this.sprites = paramArrayList;
    }
    
    public void setStartColor(StartColorBean paramStartColorBean)
    {
      this.startColor = paramStartColorBean;
    }
    
    public void setStartColorVariance(StartColorVarianceBean paramStartColorVarianceBean)
    {
      this.startColorVariance = paramStartColorVarianceBean;
    }
    
    public void setStartParticleSize(StartParticleSizeBean paramStartParticleSizeBean)
    {
      this.startParticleSize = paramStartParticleSizeBean;
    }
    
    public void setStartParticleSizeVariance(StartParticleSizeVarianceBean paramStartParticleSizeVarianceBean)
    {
      this.startParticleSizeVariance = paramStartParticleSizeVarianceBean;
    }
    
    public void setTangentialAccelVariance(TangentialAccelVarianceBean paramTangentialAccelVarianceBean)
    {
      this.tangentialAccelVariance = paramTangentialAccelVarianceBean;
    }
    
    public void setTangentialAcceleration(TangentialAccelerationBean paramTangentialAccelerationBean)
    {
      this.tangentialAcceleration = paramTangentialAccelerationBean;
    }
    
    public void setTexture(TextureBean paramTextureBean)
    {
      this.texture = paramTextureBean;
    }
    
    public void setYCoordFlipped(YCoordFlippedBean paramYCoordFlippedBean)
    {
      this.yCoordFlipped = paramYCoordFlippedBean;
    }
    
    public static class AbsolutePositionBean
    {
      public float value;
    }
    
    public static class Angle3DBean
    {
      public float x;
      public float y;
      public float z;
    }
    
    public static class AngleBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class AngleVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class BlendFuncDestinationBean
    {
      public int value;
      
      public int getValue()
      {
        return this.value;
      }
    }
    
    public static class BlendFuncSourceBean
    {
      public int value;
      
      public int getValue()
      {
        return this.value;
      }
    }
    
    public static class DurationBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class Emission3DVector
    {
      public float x;
      public float y;
      public float z;
      
      public Emission3DVector(float paramFloat1, float paramFloat2, float paramFloat3)
      {
        this.x = paramFloat1;
        this.y = paramFloat2;
        this.z = paramFloat3;
      }
    }
    
    public static class Emission3DVectorVariance
    {
      public float x;
      public float y;
      public float z;
      
      public Emission3DVectorVariance(float paramFloat1, float paramFloat2, float paramFloat3)
      {
        this.x = paramFloat1;
        this.y = paramFloat2;
        this.z = paramFloat3;
      }
    }
    
    public static class EmitterTypeBean
    {
      public int value;
      
      public int getValue()
      {
        return this.value;
      }
    }
    
    public static class FinishColorBean
    {
      public float alpha;
      public float blue;
      public float green;
      public float red;
    }
    
    public static class FinishColorVarianceBean
    {
      public float alpha;
      public float blue;
      public float green;
      public float red;
    }
    
    public static class FinishParticleSizeBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class FinishParticleSizeVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
      
      public void setValue(float paramFloat)
      {
        this.value = paramFloat;
      }
    }
    
    public static class GravityBean
    {
      public float x;
      public float y;
      public float z;
    }
    
    public static class MaxParticlesBean
    {
      public int value;
      
      public int getValue()
      {
        return this.value;
      }
    }
    
    public static class MaxRadiusBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class MaxRadiusVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class MinRadiusBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class MinRadiusVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class ParticleLifeSpanBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class ParticleLifespanVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class ParticlePath
    {
      public String path;
    }
    
    public static class RadialAccelVarianceBean
    {
      public float value;
    }
    
    public static class RadialAccelerationBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class RotatePerSecondBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class RotatePerSecondVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class RotationEndBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class RotationEndVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class RotationStartBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class RotationStartVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class SourcePositionBean
    {
      public float x;
      public float y;
      public float z;
    }
    
    public static class SourcePositionVarianceBean
    {
      public float x;
      public float y;
      public float z;
    }
    
    public static class SpeedBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class SpeedVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class Sprite
    {
      public boolean animated;
      public int blending;
      public int column;
      public int frameCount;
      public int frameDuration;
      public int height;
      public int imageHeight;
      public int imageWidth;
      public int looped;
      public String path;
      public int row;
      public int width;
    }
    
    public static class StartColorBean
    {
      public float alpha;
      public float blue;
      public float green;
      public float red;
    }
    
    public static class StartColorVarianceBean
    {
      public float alpha;
      public float blue;
      public float green;
      public float red;
    }
    
    public static class StartParticleSizeBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class StartParticleSizeVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class TangentialAccelVarianceBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class TangentialAccelerationBean
    {
      public float value;
      
      public float getValue()
      {
        return this.value;
      }
    }
    
    public static class TextureBean
    {
      public String data;
      public String name;
    }
    
    public static class YCoordFlippedBean
    {
      public int value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleConfig
 * JD-Core Version:    0.7.0.1
 */