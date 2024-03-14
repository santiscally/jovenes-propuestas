import { Box, Button, ButtonGroup, Flex, Heading } from "@chakra-ui/react";
import SearchBar from "./SearchBar";

const Navigation = () => {
  return (
    <nav>
      <Box
        w="100%"
        h={"80px"}
        borderBottom={"1px solid #E2E8F0"}
        boxShadow={"md"}
      >
        <Flex
          direction={"row"}
          alignItems={"center"}
          h={"100%"}
          justifyContent={"space-between"}
          maxW={"1280px"}
          m={"auto"}
          gap={"50px"}
        >
          <Heading size={"xl"} color={"brand.400"}>
            Logo
          </Heading>
          <SearchBar />
          <ButtonGroup>
            <Button
              bg={"brand.200"}
              color={"brand.700"}
              _hover={{ bg: "brand.300" }}
              _active={{ bg: "brand.400" }}
            >
              Iniciar sesion
            </Button>
            <Button
              bg={"brand.200"}
              color={"brand.700"}
              _hover={{ bg: "brand.300" }}
              _active={{ bg: "brand.400" }}
            >
              Registro
            </Button>
          </ButtonGroup>
        </Flex>
      </Box>
    </nav>
  );
};

export default Navigation;
