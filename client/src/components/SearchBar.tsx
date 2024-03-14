import { Search2Icon } from "@chakra-ui/icons";
import { Input, InputGroup, InputLeftElement } from "@chakra-ui/react";

const SearchBar = () => {
  return (
    <InputGroup>
      <InputLeftElement>
        <Search2Icon color={"brand.300"} />
      </InputLeftElement>
      <Input
        placeholder="Buscar proyectos..."
        size={"md"}
        boxShadow={"xs"}
        focusBorderColor="#213789"
      />
    </InputGroup>
  );
};

export default SearchBar;
