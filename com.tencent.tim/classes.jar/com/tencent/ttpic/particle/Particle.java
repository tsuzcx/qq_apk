package com.tencent.ttpic.particle;

public class Particle
{
  public float angle;
  public Vector3 angle3d = new Vector3();
  public Vector4 color = new Vector4();
  public float degreesPerSecond;
  public Vector4 deltaColor = new Vector4();
  public Vector3 direction = new Vector3();
  public int frameIndex;
  public float lifespan;
  public float particleSize;
  public float particleSizeDelta;
  public Vector3 position = new Vector3();
  public float radialAcceleration;
  public float radius;
  public float radiusDelta;
  public float rotation;
  public float rotationDelta;
  public int spriteIndex;
  public Vector3 startPos = new Vector3();
  public float tangentialAcceleration;
  public float timeToLive;
  
  public void copy(Particle paramParticle)
  {
    this.position.copy(paramParticle.position);
    this.direction.copy(paramParticle.direction);
    this.startPos.copy(paramParticle.startPos);
    this.color.copy(paramParticle.color);
    this.deltaColor.copy(paramParticle.deltaColor);
    this.rotation = paramParticle.rotation;
    this.rotationDelta = paramParticle.rotationDelta;
    this.radialAcceleration = paramParticle.radialAcceleration;
    this.tangentialAcceleration = paramParticle.tangentialAcceleration;
    this.radius = paramParticle.radius;
    this.radiusDelta = paramParticle.radiusDelta;
    this.angle = paramParticle.angle;
    this.angle3d = paramParticle.angle3d;
    this.degreesPerSecond = paramParticle.degreesPerSecond;
    this.particleSize = paramParticle.particleSize;
    this.particleSizeDelta = paramParticle.particleSizeDelta;
    this.timeToLive = paramParticle.timeToLive;
    this.lifespan = paramParticle.lifespan;
    this.frameIndex = paramParticle.frameIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.Particle
 * JD-Core Version:    0.7.0.1
 */