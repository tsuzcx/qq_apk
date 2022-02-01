
precision highp float;

attribute vec4 inCoord;
attribute vec3 inNormal;
attribute vec2 inTexCoord;

uniform mat4 m4Projection;
uniform mat4 m4ModelTrans;

#define MAX_SHADOW_LIGHTS 3
uniform lowp int shadowLightNum;
uniform sampler2D shadowMap0Sampler;
uniform sampler2D shadowMap1Sampler;
uniform sampler2D shadowMap2Sampler;
uniform mat4 lightPOV[MAX_SHADOW_LIGHTS];

varying vec4 fragCoord;
varying vec3 fragNormal;
varying vec2 fragTexCoord;
varying vec4 lightPOVCoord[MAX_SHADOW_LIGHTS];

#if defined(SKINNING)

// need to define SkinCount
attribute vec4 a_blendWeights;
attribute vec4 a_blendIndices;
uniform vec4 u_matrixPalette[SKINNING_JOINT_COUNT * 3];

vec4 _skinnedPosition;

void skinPosition(float blendWeight, int matrixIndex)
{
    vec4 tmp;
    tmp.x = dot(inCoord, u_matrixPalette[matrixIndex]);
    tmp.y = dot(inCoord, u_matrixPalette[matrixIndex + 1]);
    tmp.z = dot(inCoord, u_matrixPalette[matrixIndex + 2]);
    tmp.w = inCoord.w;
    _skinnedPosition += blendWeight * tmp;
}

vec4 getPosition()
{
    _skinnedPosition = vec4(0.0);
    float blendWeight = a_blendWeights[0];
    int matrixIndex = int (a_blendIndices[0]) * 3;
    skinPosition(blendWeight, matrixIndex);
    blendWeight = a_blendWeights[1];
    matrixIndex = int(a_blendIndices[1]) * 3;
    skinPosition(blendWeight, matrixIndex);
    blendWeight = a_blendWeights[2];
    matrixIndex = int(a_blendIndices[2]) * 3;
    skinPosition(blendWeight, matrixIndex);
    blendWeight = a_blendWeights[3];
    matrixIndex = int(a_blendIndices[3]) * 3;
    skinPosition(blendWeight, matrixIndex);
    return _skinnedPosition;
}

vec3 _skinnedNormal;

void skinTangentSpaceVector(vec3 vector, float blendWeight, int matrixIndex)
{
    vec3 tmp;
    tmp.x = dot(vector, u_matrixPalette[matrixIndex].xyz);
    tmp.y = dot(vector, u_matrixPalette[matrixIndex + 1].xyz);
    tmp.z = dot(vector, u_matrixPalette[matrixIndex + 2].xyz);
    _skinnedNormal += blendWeight * tmp;
}

vec3 getTangentSpaceVector(vec3 vector)
{
    _skinnedNormal = vec3(0.0);
    // Transform normal to view space using matrix palette with four matrices used to transform a vertex.
    float blendWeight = a_blendWeights[0];
    int matrixIndex = int (a_blendIndices[0]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    blendWeight = a_blendWeights[1];
    matrixIndex = int(a_blendIndices[1]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    blendWeight = a_blendWeights[2];
    matrixIndex = int(a_blendIndices[2]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    blendWeight = a_blendWeights[3];
    matrixIndex = int(a_blendIndices[3]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    return _skinnedNormal;
}

vec3 getNormal()
{
    return getTangentSpaceVector(inNormal);
}

#else

vec4 getPosition()
{
    return inCoord;
}

vec3 getNormal()
{
    return inNormal;
}

#endif

void main()
{
    fragCoord = getPosition();
    fragTexCoord = inTexCoord;
    fragNormal = getNormal();

     lightPOVCoord[0] = lightPOV[0] * m4ModelTrans * fragCoord;

    gl_Position = m4Projection * m4ModelTrans * fragCoord;
}