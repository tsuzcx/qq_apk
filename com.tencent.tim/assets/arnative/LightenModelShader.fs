#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif

varying vec2 fragTexCoord;
varying vec3 fragNormal;
varying vec4 fragCoord;

uniform mat4 m4ModelTrans;
uniform mat3 m3InverseTrans;

uniform vec3 cameraPosition;
uniform float materialShininess;
uniform vec3 materialSpecularColor;
uniform int numLights;

#define MAX_LIGHTS 3
uniform struct Light {
    vec4 position;
    vec3 intensities; //a.k.a the color of the light
    float attenuation;
    float ambientCoefficient;
    float coneAngleCos;
    float outterAngleCos;
    vec3 coneDirection;
} allLights[MAX_LIGHTS];

uniform sampler2D defaultSampler;

vec3 ApplyLight(Light light, vec3 surfaceColor, vec3 normal, vec3 surfacePos, vec3 surfaceToCamera) {
    vec3 surfaceToLight;
    float attenuation = 1.0;
    if(light.position.w == 0.0) {
        //directional light
        surfaceToLight = normalize(light.position.xyz);
        attenuation = 1.0; //no attenuation for directional lights
    } else {
        //point light
        surfaceToLight = normalize(light.position.xyz - surfacePos);
        float distanceToLight = length(light.position.xyz - surfacePos);
        attenuation = 1.0 / (1.0 + light.attenuation * distanceToLight * distanceToLight);
        
        //cone restrictions (affects attenuation)
        
        float curAngleCos = dot(-surfaceToLight, normalize(light.coneDirection));
        
        //float lightToSurfaceAngle = degrees(acos(cosCurAngle));
        float fade = clamp((curAngleCos - light.outterAngleCos) / (light.coneAngleCos - light.outterAngleCos), 0.0, 1.0);
        attenuation = attenuation * fade;
    }
    
    //ambient
    vec3 ambient = light.ambientCoefficient * surfaceColor.rgb * light.intensities;
    
    //diffuse
    float diffuseCoefficient = max(0.0, dot(normal, surfaceToLight));
    vec3 diffuse = diffuseCoefficient * surfaceColor.rgb * light.intensities * (1.0 - light.ambientCoefficient);
    
    //specular
    float specularCoefficient = 0.0;
    if(diffuseCoefficient > 0.0)
        specularCoefficient = pow(max(0.0, dot(surfaceToCamera, reflect(-surfaceToLight, normal))), materialShininess);
    vec3 specular = specularCoefficient * materialSpecularColor * light.intensities;
    
    //linear color (color before gamma correction)
    return ambient + attenuation*(diffuse + specular);
}

void main() {
    vec3 normal = normalize(m3InverseTrans * fragNormal);
    vec3 surfacePos = vec3(m4ModelTrans * fragCoord);
    vec4 surfaceColor = texture2D(defaultSampler, fragTexCoord);
    vec3 surfaceToCamera = normalize(cameraPosition - surfacePos);
    
    //combine color from all the lights
    vec3 linearColor = vec3(0);
    linearColor += ApplyLight(allLights[0], surfaceColor.rgb, normal, surfacePos, surfaceToCamera);

    //final color (after gamma correction)
//    vec3 gamma = vec3(1.0/2.2);
//    gl_FragColor = vec4(pow(linearColor, gamma), surfaceColor.a);
    gl_FragColor = vec4(linearColor, surfaceColor.a); // without gamma correction
}