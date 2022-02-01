precision highp float;

uniform sampler2D defaultSampler;

varying vec2 fragTexCoord;
varying vec3 fragNormal;
varying vec4 fragCoord;

uniform mat4 m4ModelTrans;
uniform mat3 m3InverseTrans;

uniform vec3 cameraPosition;

float uKa = 0.28;
float uKs = 0.7;
float uKe = 0.23;
float uKd = 0.99;

//MAX_LIGHTS
#if defined(MAX_LIGHTS) && (MAX_LIGHTS > 0)

uniform float materialShininess;
uniform vec3 materialSpecularColor;

varying vec3 surfaceToCamera;
varying vec3 surfaceToLight[MAX_LIGHTS];

uniform struct Light {
    vec4 position;
    vec3 intensities; //a.k.a the color of the light
    float attenuation;
    float ambientCoefficient;
    float coneAngleCos;
    float outterAngleCos;
    vec3 coneDirection;
} allLights[MAX_LIGHTS];

#if defined(NORMALMAP)
uniform sampler2D normalMap;
varying vec3 camTangentPosition;
#endif

#if defined(SHADOW)
uniform sampler2D shadowMap0Sampler;

#if (MAX_LIGHTS > 1)
uniform sampler2D shadowMap1Sampler;
#if (MAX_LIGHTS > 2)
uniform sampler2D shadowMap2Sampler;
#endif //SHADOW
#endif // > 2
#endif // > 1
#endif // MAX_LIGHTS

#if defined(MAX_LIGHTS) && (MAX_LIGHTS > 0)
#if defined(SHADOW)
varying vec4 lightPOVCoord[MAX_LIGHTS];
#endif

vec3 ApplyLight(int index, Light light, vec3 surfaceColor, vec3 normal, vec3 surfacePos, vec3 surfaceToCamera, float spec) {
    vec3 surface2L = normalize(surfaceToLight[index]);
    float attenuation = 1.0;
    
    if(light.position.w == 0.0) {
        //directional light
        attenuation = 1.0; //no attenuation for directional lights
    } else {
        //point light
        float distanceToLight = length(surface2L);
        attenuation = 1.0 / (1.0 + light.attenuation * distanceToLight * distanceToLight);
        
        //cone restrictions (affects attenuation)
        
        float curAngleCos = dot(-surface2L, normalize(light.coneDirection));
        
        //float lightToSurfaceAngle = degrees(acos(cosCurAngle));
        float fade = clamp((curAngleCos - light.outterAngleCos) / (light.coneAngleCos - light.outterAngleCos), 0.0, 1.0);
        attenuation = 1.0; //attenuation * fade;
    }
    
    //ambient
    vec3 ambient = uKa * (light.ambientCoefficient + 0.8) * surfaceColor.rgb * light.intensities;
    
    // if is in shadow
    float shadowCoeff = 1.0;
    
#if defined(SHADOW)
#if (MAX_LIGHTS > 0)
    if (index < MAX_LIGHTS) {
        vec4 shadowMapCoord = lightPOVCoord[index]; //
        vec2 shadowUV;
        shadowUV.x = 0.5 * shadowMapCoord.x / shadowMapCoord.w + 0.5;
        shadowUV.y = 0.5 * shadowMapCoord.y / shadowMapCoord.w + 0.5;
        
        if (shadowUV.x < 1.0 && shadowUV.x > 0.0 && shadowUV.y < 1.0 && shadowUV.y > 0.0)
        {
            highp float depth = 0.5 * shadowMapCoord.z / shadowMapCoord.w + 0.5;
            highp float lightDepth = 0.0;
            
            if (index == 0) {
                lightDepth = texture2D(shadowMap0Sampler, shadowUV.st).x;
            }
#if (MAX_LIGHTS > 1)
            else if (index == 1) {
                lightDepth = texture2D(shadowMap1Sampler, shadowUV.st).x;
            }
#if (MAX_LIGHTS > 2)
            else if (index == 2) {
                lightDepth = texture2D(shadowMap2Sampler, shadowUV.st).x;
            }
#endif
#endif
            if (depth > lightDepth + 0.01)
                shadowCoeff = 0.2;
        }
    }
#endif
#endif // end of if defined SHADOW
    
    //diffuse
    float diffuseCoefficient = max(0.0, dot(normal, surface2L));
    vec3 diffuse = uKd * diffuseCoefficient * surfaceColor.rgb * light.intensities * (1.0 - light.ambientCoefficient);
//    vec3 diffuse = diffuseCoefficient * surfaceColor.rgb;
    
    //specular
    float shine = materialShininess;
    float specularCoefficient = 0.0;
    if(diffuseCoefficient > 0.0 && shine > 1.0) {
        float specBase = max(0.01, dot(surfaceToCamera, reflect(-surface2L, normal)));
    //    if (specBase == 0.01) {
    //        return vec3(0.0, 1.0, 0.0);
    //    } else
        specularCoefficient = pow(specBase, materialShininess);
    } else {
    //    return vec3(1.0, 0.0, 0.0);
    }
    vec3 specular = uKs * spec * specularCoefficient * materialSpecularColor * light.intensities;
//    vec3 specular = specularCoefficient * materialSpecularColor;
    
    return ambient + shadowCoeff * attenuation * (diffuse + specular);
}
#endif //end of if defined MAX_LIGHT

void main() {
#if defined(NORMALMAP)
    vec4 nmColor = texture2D(normalMap, fragTexCoord);
#if defined(SPECULARMAP)
    nmColor.rgb = nmColor.rgb / nmColor.a;
    float spec = nmColor.a;
#else
    float spec = 1.0;
#endif
    vec3 normal = normalize(nmColor.rgb * 2.0 - 1.0);
#else
    vec3 normal = normalize(m3InverseTrans * fragNormal);
    float spec = 1.0;
#endif
    vec3 surfacePos = vec3(m4ModelTrans * fragCoord); // world coord
    vec4 surfaceColor = texture2D(defaultSampler, fragTexCoord);
    
#if defined(MAX_LIGHTS) && (MAX_LIGHTS > 0)
    vec3 linearColor = vec3(0);
    for (int i = 0; i < MAX_LIGHTS; i++) {
        linearColor += ApplyLight(i, allLights[i], surfaceColor.rgb, normal, surfacePos, normalize(surfaceToCamera), spec);
    }
    gl_FragColor = vec4(linearColor, surfaceColor.a); // without gamma correction
    
    //vec3 gamma = vec3(1.0/2.2);
    //gl_FragColor = vec4(pow(linearColor, gamma), surfaceColor.a);
#else
    gl_FragColor = surfaceColor; // without gamma correction
#endif
    
}



