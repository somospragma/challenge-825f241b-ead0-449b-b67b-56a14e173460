# Endurecimiento de un servicio de pagos distribuido

El servicio de pagos de una entidad financiera necesita ser endurecido para mitigar riesgos y vulnerabilidades de seguridad. El servicio interactúa con un motor antifraude, un buró de riesgos y un core bancario. Debe procesar hasta 1 500 solicitudes por segundo en hora pico, con un SLA de 99.9%. Las solicitudes deben ser idempotentes por número de operación y canal, con una ventana de 24 horas para reintentos. El servicio debe emitir un evento al sistema de auditoría por cada aceptación. Los modos de falla a considerar incluyen timeout del buró mayor a 2 segundos, respuestas 5xx del core y pérdida de conexión durante la escritura.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Analiza riesgos y vulnerabilidades de seguridad |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 1 semana |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Evaluación de riesgos y vulnerabilidades

**Objetivo:** Identificar y documentar los riesgos y vulnerabilidades del servicio de pagos

**Tiempo estimado:** 2 días

**Instrucciones:**

- Analiza el servicio de pagos y documenta los riesgos y vulnerabilidades identificados, incluyendo aquellos relacionados con OWASP Top 10 y CWE.
- Proporciona una descripción detallada de cada riesgo y vulnerabilidad, incluyendo su impacto y probabilidad.

**Entregable:** Documento de evaluación de riesgos y vulnerabilidades

<details>
<summary>Pistas de conocimiento</summary>

- Considera los modos de falla específicos del dominio al evaluar los riesgos y vulnerabilidades.

</details>

### Fase 2: Implementación de mitigaciones

**Objetivo:** Implementar mitigaciones para los riesgos y vulnerabilidades identificados

**Tiempo estimado:** 3 días

**Instrucciones:**

- Proponer e implementar mitigaciones para los riesgos y vulnerabilidades identificados en la fase anterior.
- Considerar trade-offs y justificar las decisiones tomadas.

**Entregable:** Implementación de mitigaciones en el servicio de pagos

<details>
<summary>Pistas de conocimiento</summary>

- Considera los trade-offs y las consecuencias de cada mitigación al tomar tus decisiones.

</details>

### Fase 3: Validación y auditoría

**Objetivo:** Validar y auditar las mitigaciones implementadas

**Tiempo estimado:** 2 días

**Instrucciones:**

- Realizar pruebas y auditorías para validar las mitigaciones implementadas.
- Documentar los resultados y proporcionar recomendaciones para mejoras futuras.

**Entregable:** Reporte de validación y auditoría de las mitigaciones implementadas

<details>
<summary>Pistas de conocimiento</summary>

- Considera los modos de falla específicos del dominio al realizar las pruebas y auditorías.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los riesgos y vulnerabilidades de seguridad en el contexto del servicio de pagos?
- **paraQueSirve**: ¿Para qué sirve identificar y mitigar los riesgos y vulnerabilidades de seguridad en el servicio de pagos?
- **erroresComunes**: ¿Cuáles son los errores comunes al identificar y mitigar los riesgos y vulnerabilidades de seguridad en el servicio de pagos?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de mitigaciones para los riesgos y vulnerabilidades de seguridad en el servicio de pagos?

## Criterios de Evaluacion

- Identificación y documentación de riesgos y vulnerabilidades.
- Implementación de mitigaciones efectivas.
- Validación y auditoría de las mitigaciones implementadas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
