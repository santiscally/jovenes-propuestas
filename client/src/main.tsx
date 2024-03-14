import React from "react";
import ReactDOM from "react-dom/client";
import Router from "./router/Router.tsx";
import { ChakraBaseProvider } from "@chakra-ui/react";
import { theme } from "./theme/BaseTheme.tsx";

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <ChakraBaseProvider theme={theme}>
      <Router />
    </ChakraBaseProvider>
  </React.StrictMode>
);
