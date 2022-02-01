
precision highp float;

attribute vec4 inCoord;
attribute vec3 inNormal;
attribute vec2 inTexCoord;

uniform mat4 m4Projection;
uniform mat4 m4ModelTrans;

uniform vec3 cameraPosition;

//MAX_LIGHTS

#if defined(MAX_LIGHTS) && (MAX_LIGHTS > 0)

uniform mat3 m3InverseTrans;

uniform struct Light {
    vec4 position;
    vec3 intensities; //a.k.a the color of the light
    float attenuation;
    float ambientCoefficient;
    float coneAngleCos;
    float outterAngleCos;
    vec3 coneDirection;
} allLights[MAX_LIGHTS];

#if defined(SHADOW)
    uniform mat4 lightPOV[MAX_LIGHTS];
    uniform sampler2D shadowMap0Sampler;
#if (MAX_LIGHTS > 1)
    uniform sampler2D shadowMap1Sampler;
#if (MAX_LIGHTS > 2)
    uniform sampler2D shadowMap2Sampler;
#endif
#endif
#endif
#endif

varying vec4 fragCoord;
varying vec3 fragNormal;
varying vec2 fragTexCoord;

#if defined(NORMALMAP)
attribute vec3 a_tangent;
attribute vec3 a_binormal;
#endif

#if defined(MAX_LIGHTS) && (MAX_LIGHTS > 0)
#if defined(SHADOW)
    varying vec4 lightPOVCoord[MAX_LIGHTS];
#endif
#endif

#if defined(SKINNING) && (SKNNING_JOINT_COUNT > 0)

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

#if defined(NORMALMAP)
vec3 getTangent()
{
    return getTangentSpaceVector(a_tangent);
}
vec3 getBinormal()
{
    return getTangentSpaceVector(a_binormal);
}
#endif

#else // if no skinning

vec4 getPosition()
{
    return inCoord;
}

vec3 getNormal()
{
    return inNormal;
}

#if defined(NORMALMAP)
vec3 getTangent()
{
    return a_tangent;
}
vec3 getBinormal()
{
    return a_binormal;
}
#endif

#endif

#if defined(MAX_LIGHTS) && MAX_LIGHTS > 0
varying vec3 surfaceToCamera;
varying vec3 surfaceToLight[MAX_LIGHTS];
#endif

void main()
{
    fragCoord = getPosition();
    fragTexCoord = inTexCoord;
    fragNormal = getNormal();
    
#if defined(MAX_LIGHTS) && MAX_LIGHTS > 0
    
    vec4 vert = m4ModelTrans * fragCoord;  // world coord
#if defined(NORMALMAP)
    vec3 tangent = getTangent();
    vec3 binormal = getBinormal();
    vec3 normal = getNormal();
    
    // tbn with world->model transform
    vec3 normalVector = (m3InverseTrans * normal);
    vec3 tangentVector  = (m3InverseTrans * tangent);
    vec3 binormalVector = (m3InverseTrans * binormal);
    mat3 tangentSpaceTransformMatrix = mat3(tangentVector.x, binormalVector.x, normalVector.x, tangentVector.y, binormalVector.y, normalVector.y, tangentVector.z, binormalVector.z, normalVector.z);
    
    
    for (int i = 0; i < MAX_LIGHTS; i++) {
        vec3 lightPos = allLights[i].position.xyz; // world coord
//        lightPos = vec3(100.0, 100.0, 100.0);
        if (allLights[i].position.w == 0.0) {
            surfaceToLight[i] = tangentSpaceTransformMatrix * (lightPos);
        } else {
            surfaceToLight[i] = tangentSpaceTransformMatrix * (lightPos - vert.xyz);
        }
    }
    surfaceToCamera = tangentSpaceTransformMatrix * (cameraPosition - vert.xyz); // camera in world coord
#else
    for (int i = 0; i < MAX_LIGHTS; i++) {
        vec3 lightPos = allLights[i].position.xyz;
        if (allLights[i].position.w == 0.0) {
            surfaceToLight[i] = (lightPos);
        } else {
            surfaceToLight[i] = (lightPos - vert.xyz);
        }
    }
    surfaceToCamera = cameraPosition - vert.xyz;
#endif
    
    
    
#if defined(SHADOW)
    for (int i = 0; i < MAX_LIGHTS; i++) {
        lightPOVCoord[i] = lightPOV[i] * m4ModelTrans * fragCoord;
    }
#endif
    
#endif

    gl_Position = m4Projection * m4ModelTrans * fragCoord;
}
