(ns ring.swagger.json-schema-dirty
  "Json-type multimethod implementations for some Schemas which can't be
   properly described using Json Schema."
  (:require [ring.swagger.json-schema :refer :all]))

(extend-protocol JsonSchema
  schema.core.ConditionalSchema
  (convert [e _]
    {:type "void" :oneOf (mapv (comp ->swagger second) (:preds-and-schemas e))}))
